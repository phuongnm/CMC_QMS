package com.cmc.web;
import com.cmc.domain.Projects;
import com.cmc.svr.ProjectsService;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

@RooController(path = "/projectss", entity = Projects.class, service = ProjectsService.class)
@RooThymeleaf
public class ProjectsController {
}
