package com.cmc.web;
import com.cmc.domain.Projects;
import com.cmc.svr.ProjectsService;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;

@RooFormatter(entity = Projects.class, service = ProjectsService.class)
public class ProjectsFormatter {
}
