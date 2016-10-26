package com.cmc.web;
import com.cmc.domain.Issues;
import com.cmc.svr.IssuesService;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;

@RooFormatter(entity = Issues.class, service = IssuesService.class)
public class IssuesFormatter {
}
