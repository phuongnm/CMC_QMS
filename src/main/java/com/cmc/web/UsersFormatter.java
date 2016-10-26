package com.cmc.web;
import com.cmc.domain.Users;
import com.cmc.svr.UsersService;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;

@RooFormatter(entity = Users.class, service = UsersService.class)
public class UsersFormatter {
}
