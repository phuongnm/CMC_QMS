package com.cmc.web;
import java.util.ArrayList;
import java.util.List;

import com.cmc.domain.Issues;
import com.cmc.svr.IssuesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RooController(path = "/issueses", entity = Issues.class, service = IssuesService.class)
@RooThymeleaf
public class IssuesController {
	
	
	@RequestMapping("/findByDoneRatio/{ratio}")
	public ResponseEntity findByDoneRatio(@PathVariable("ratio") int ratio){
		List<Issues> result = new ArrayList();
		try{
			result = issuesService.findByDoneRatioEquals(ratio);
			
		}catch(Exception e){
			
		}
		return new ResponseEntity(result, HttpStatus.OK);
		
	}
}
