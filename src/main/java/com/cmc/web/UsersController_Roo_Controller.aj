// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.cmc.web;

import com.cmc.svr.UsersService;
import com.cmc.web.UsersController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

privileged aspect UsersController_Roo_Controller {
    
    declare @type: UsersController: @Controller;
    
    declare @type: UsersController: @RequestMapping("/userss");
    
    public UsersService UsersController.usersService;
    
    @Autowired
    public UsersController.new(UsersService usersService) {
        this.usersService = usersService;
    }

}
