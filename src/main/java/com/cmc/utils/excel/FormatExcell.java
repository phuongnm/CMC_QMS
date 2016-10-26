/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmc.utils.excel;

import java.lang.reflect.Method;
import org.apache.poi.ss.usermodel.CellStyle;

/**
 *
 * @author NVTiep
 */
public class FormatExcell {

    private String cellColumn;
    private ExcellHeaderComment headerCommand;
    private CellAlign cellAlign;

    private int columnWidth;
    private boolean columnHiden;
    private Method getterColumn;
    private CellStyle cellStyle;
    private boolean columnView;

    public enum CellAlign {

        ALIGN_LEFT,
        ALIGN_RIGHT,
        ALIGN_CENTER,
        FORMAT_DECIMAL,
    }

    public FormatExcell(String cellColumn, ExcellHeaderComment headerCommand, CellAlign cellAlign, int columnWidth, boolean columnView) {
        this.cellColumn = cellColumn;
        this.headerCommand = headerCommand;
        this.cellAlign = cellAlign;
        this.columnView = columnView;
        this.columnWidth = columnWidth;
    }

    public FormatExcell(String cellColumn, ExcellHeaderComment headerCommand, CellAlign cellAlign, int columnWidth, boolean columnView, boolean columnHiden) {
        this.cellColumn = cellColumn;
        this.headerCommand = headerCommand;
        this.cellAlign = cellAlign;
        this.columnWidth = columnWidth;
        this.columnHiden = columnHiden;
        this.columnView = columnView;
    }

    public String getCellColumn() {
        return cellColumn;
    }

    public void setCellColumn(String cellColumn) {
        this.cellColumn = cellColumn;
    }

    public ExcellHeaderComment getHeaderCommand() {
        return headerCommand;
    }

    public void setHeaderCommand(ExcellHeaderComment headerCommand) {
        this.headerCommand = headerCommand;
    }

    public CellAlign getCellAlign() {
        return cellAlign;
    }

    public void setCellAlign(CellAlign cellAlign) {
        this.cellAlign = cellAlign;
    }

    public int getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(int columnWidth) {
        this.columnWidth = columnWidth;
    }

    public boolean getColumnHiden() {
        return columnHiden;
    }

    public void setColumnHiden(boolean columnHiden) {
        this.columnHiden = columnHiden;
    }

    public Method getGetterColumn() {
        return getterColumn;
    }

    public void setGetterColumn(Method getterColumn) {
        this.getterColumn = getterColumn;
    }

    public CellStyle getCellStyle() {
        return cellStyle;
    }

    public void setCellStyle(CellStyle cellStyle) {
        this.cellStyle = cellStyle;
    }

    public boolean isColumnView() {
        return columnView;
    }

    public void setColumnView(boolean columnView) {
        this.columnView = columnView;
    }

}
