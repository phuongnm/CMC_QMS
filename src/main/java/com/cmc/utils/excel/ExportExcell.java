/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmc.utils.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.cmc.utils.BundleUtils;
import com.cmc.utils.DataUtil;
import com.cmc.utils.excel.FormatExcell.CellAlign;

/**
 *
 * @author NVTiep
 */
public class ExportExcell {

	private SXSSFWorkbook wb;
	private Sheet sh;
	private ExportExcellCelltype customCellType;
	private Class<?> c;
	private boolean flag;
	private FileOutputStream fileOut;

	public ExportExcell(String fileName, String sheetName)
			throws FileNotFoundException {

		fileOut = new FileOutputStream(fileName);
		wb = new SXSSFWorkbook(500); // keep 100 rows in memory, exceeding rows
										// will be flushed to disk
		wb.setCompressTempFiles(true);
		sh = wb.createSheet(sheetName);

	}

	public void buildSheet(List<?> lstData, List<FormatExcell> formatExcell,
			String key) {
		FormatExcell item;
		Row rowheader = sh.createRow(0);
		customCellType = new ExportExcellCelltype(wb);

		Cell cellStt = rowheader.createCell(0);
		cellStt.setCellValue(BundleUtils.getString("STT")); // get bundle
		cellStt.setCellStyle(customCellType.cellTypeColumnStt());
		for (int i = 0; i < formatExcell.size(); i++) {
			item = formatExcell.get(i);
			Cell cell = rowheader.createCell(i + 1);
			cell.setCellValue(getColumnTitle(item.getCellColumn(), key));
			cell.setCellStyle(customCellType.cellTypeHeader(false));
			sh.setColumnWidth(i + 1, item.getColumnWidth());
			sh.setColumnHidden(i + 1, item.getColumnHiden());
			if (item.getHeaderCommand() != null) {
				cell.setCellComment(getcellComment(item, cell));
			}
			setFormatCell(item);
		}
		if (DataUtil.isListNullOrEmpty(formatExcell)
				|| DataUtil.isListNullOrEmpty(lstData)) {
			return;
		}
		buildContentSheet(lstData, formatExcell);

	}

	private void buildContentSheet(List<?> lstData,
			List<FormatExcell> formatExcell) {

		int i = 1;
		for (Object itemData : lstData) {

			Row rowData = sh.createRow(i);
			Cell cellStt = rowData.createCell(0);
			cellStt.setCellValue(i);
			cellStt.setCellStyle(customCellType.cellTypeAlignCenter(false));
			i++;
			createCell(itemData, rowData, formatExcell);

		}
		try {
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.dispose();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void createCell(Object itemData, Row rowData,
			List<FormatExcell> formatExcell) {
		int i = 1;
		try {
			if (!flag) {
				getListMethod(formatExcell, itemData);
			}
			Object data = null;
			for (FormatExcell item : formatExcell) {
				String value = "";
				Cell cell = rowData.createCell(i);

				cell.setCellStyle(item.getCellStyle());
				if (item.isColumnView()) {
					data = item.getGetterColumn().invoke(itemData);
					value = DataUtil.isStringNullOrEmpty(data) ? "" : data
							.toString();
				}
				cell.setCellValue(value);
				i++;
			}
		} catch (NoSuchMethodException ex) {
			Logger.getLogger(ExportExcell.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(ExportExcell.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IllegalArgumentException ex) {
			Logger.getLogger(ExportExcell.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (InvocationTargetException ex) {
			Logger.getLogger(ExportExcell.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

	private void getListMethod(List<FormatExcell> formatExcell, Object item)
			throws NoSuchMethodException {
		flag = !flag;
		c = item.getClass();
		for (FormatExcell formatExcell1 : formatExcell) {
			if (formatExcell1.isColumnView()) {
				Method mt = c.getMethod(DataUtil
						.getGetterOfColumn(formatExcell1.getCellColumn()));
				formatExcell1.setGetterColumn(mt);
			}

		}

	}

	private void setFormatCell(FormatExcell item) {
		if (item.getCellAlign().equals(CellAlign.ALIGN_CENTER)) {
			item.setCellStyle(customCellType.cellTypeAlignCenter(true));
		} else if (item.getCellAlign().equals(CellAlign.ALIGN_LEFT)) {
			item.setCellStyle(customCellType.cellTypeAlignLeft(true));
		} else if (item.getCellAlign().equals(CellAlign.ALIGN_RIGHT)) {
			item.setCellStyle(customCellType.cellTypeAlignRight(true));
		} else if (item.getCellAlign().equals(CellAlign.FORMAT_DECIMAL)) {
			item.setCellStyle(customCellType.cellTypeFormatNumber(true));
		}
	}

	private String getColumnTitle(String column, String key) {
		return BundleUtils.getString(key + "." + column);
	}

	public SXSSFWorkbook getWb() {
		return wb;
	}

	public void setWb(SXSSFWorkbook wb) {
		this.wb = wb;
	}

	public Sheet getSh() {
		return sh;
	}

	public void setSh(Sheet sh) {
		this.sh = sh;
	}

	private Comment getcellComment(FormatExcell item, Cell cell) {
		ExcellHeaderComment headerCommand = item.getHeaderCommand();
		Drawing sSFPatriarch = sh.createDrawingPatriarch();
		CreationHelper factory = cell.getSheet().getWorkbook()
				.getCreationHelper();
		ClientAnchor anchor = factory.createClientAnchor();
		Comment comment1 = sSFPatriarch.createCellComment(anchor);

		anchor.setCol1(headerCommand.getRow1());
		anchor.setCol2(headerCommand.getRow2());
		anchor.setRow1(headerCommand.getColumn1());
		anchor.setRow2(headerCommand.getColumn2());
		anchor.setDx1(headerCommand.getDx1());
		anchor.setDx2(headerCommand.getDx2());
		anchor.setDy1(headerCommand.getDy1());
		anchor.setDy2(headerCommand.getDy2());

		RichTextString rtf1 = factory.createRichTextString(headerCommand
				.getValue());
		Font font = wb.createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		font.setBoldweight(Font.BOLDWEIGHT_NORMAL);
		font.setColor(IndexedColors.RED.getIndex());
		rtf1.applyFont(font);
		comment1.setString(rtf1);
		comment1.setAuthor("Admin");
		System.out.println("--------------------" + cell.getColumnIndex());
		System.out.println("--------------------" + cell.getRowIndex());
		comment1.setColumn(cell.getColumnIndex());
		comment1.setRow(cell.getRowIndex());
		return comment1;
	}

	public FileOutputStream getFileOut() {
		return fileOut;
	}

	public void setFileOut(FileOutputStream fileOut) {
		this.fileOut = fileOut;
	}

}
