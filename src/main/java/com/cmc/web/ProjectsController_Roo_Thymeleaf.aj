// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cmc.web;

import com.cmc.datatables.DatatablesData;
import com.cmc.datatables.DatatablesPageable;
import com.cmc.domain.Projects;
import com.cmc.repo.GlobalSearch;
import com.cmc.web.ProjectsController;
import javax.validation.Valid;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

privileged aspect ProjectsController_Roo_Thymeleaf {
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String ProjectsController.list(Model model) {
        return "projectss/list";
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Projects> ProjectsController.list(GlobalSearch search, Pageable pageable) {
        Page<Projects> projects = projectsService.findAll(search, pageable);
        return projects;
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/vnd.datatables+json")
    @ResponseBody
    public DatatablesData<Projects> ProjectsController.list(GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Projects> projects = list(search, pageable);
        long allAvailableProjects = projectsService.count();
        return new DatatablesData<Projects>(projects, allAvailableProjects, draw);
    }
    
    @RequestMapping(value = "/create-form", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String ProjectsController.createForm(Model model) {
        model.addAttribute(new Projects());
        populateForm(model);
        return "projectss/create";
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String ProjectsController.create(@Valid @ModelAttribute Projects projects, BindingResult result, RedirectAttributes redirectAttrs, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return "projectss/create";
        }
        Projects newProjects = projectsService.save(projects);
        redirectAttrs.addAttribute("id", newProjects.getId());
        return "redirect:/projectss/{id}";
    }
    
    @RequestMapping(value = "/{projects}/edit-form", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String ProjectsController.editForm(@PathVariable("projects") Projects projects, Model model) {
        populateForm(model);
        return "projectss/edit";
    }
    
    @RequestMapping(value = "/{projects}", method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
    public String ProjectsController.update(@Valid @ModelAttribute Projects projects, BindingResult result, RedirectAttributes redirectAttrs, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return "projectss/edit";
        }
        Projects savedProjects = projectsService.save(projects);
        redirectAttrs.addAttribute("id", savedProjects.getId());
        return "redirect:/projectss/{id}";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
    public String ProjectsController.delete(@PathVariable("id") Long id, Model model) {
        projectsService.delete(id);
        return "redirect:/projectss";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity ProjectsController.delete(@PathVariable("id") Long id) {
        projectsService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{projects}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String ProjectsController.show(@PathVariable("projects") Projects projects, Model model) {
        return "projectss/show";
    }
    
    public void ProjectsController.populateForm(Model model) {
        populateFomats(model);
    }
    
    public void ProjectsController.populateFomats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }
    
}