package com.cmc.web;
import com.cmc.domain.Users;
import com.cmc.svr.UsersService;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;

@RooController(path = "/userss", entity = Users.class, service = UsersService.class)
@RooThymeleaf
public class UsersController {
}
