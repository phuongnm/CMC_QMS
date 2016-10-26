package com.cmc.web;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cmc.domain.Issues;
import com.cmc.svr.IssuesService;
import com.cmc.utils.BundleUtils;
import com.cmc.utils.DateUtil;
import com.cmc.utils.excel.ExcellHeaderComment;
import com.cmc.utils.excel.ExportExcell;
import com.cmc.utils.excel.FormatExcell;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	IssuesService issuesService;

	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	public ResponseEntity<Object> listAllUsers() {
		String result = "success";
//		result = BundleUtils.getString("error_NotNull");

		ExportExcell exportExcell = null;
		String fileName = "D://Export//"
				+ DateUtil.date2ddMMyyyyHHMMssNoSlash(new Date()) + "_ListIssues.xlsx";
		try {
			exportExcell = new ExportExcell(fileName, "Sheet 1");
		} catch (FileNotFoundException ex) {
			System.out.println("Start**********************************"
					+ ex.getMessage());
		}
		// Khoi tao dinh dang fomat cho cell
		List<FormatExcell> formatExcells = new ArrayList<>();
		// Khoi tao collumn co header
		ExcellHeaderComment excellHeaderComment = new ExcellHeaderComment(0, 0,
				0, 0, 0, 4, 3, 6,
				BundleUtils.getString("comment.description"));
		// Add dinh dang excel cho tung cot
		formatExcells.add(new FormatExcell("subject", null,
				FormatExcell.CellAlign.ALIGN_LEFT, 10000, true));
		formatExcells.add(new FormatExcell("description", excellHeaderComment,
				FormatExcell.CellAlign.ALIGN_LEFT, 15000, true));
		formatExcells.add(new FormatExcell("createdOn", null,
				FormatExcell.CellAlign.ALIGN_CENTER, 8000, true));
		formatExcells.add(new FormatExcell("startDate", null,
				FormatExcell.CellAlign.ALIGN_CENTER, 8000, true));
		List<Issues> lst = issuesService.findAll();
		exportExcell.buildSheet(lst.subList(0, 100), formatExcells, "issues");
		// result = DataUtil.isListNullOrEmpty(lst) ? "null" :"size:" +
		// lst.size();
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}
}
