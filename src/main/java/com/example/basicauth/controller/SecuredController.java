package com.example.basicauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.RolesAllowed;

@Controller
public class SecuredController {

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public String getUserPage(){
        // some logic
        System.out.println("Get user page");
        return "user";
    }

    @GetMapping("/admin")
    @RolesAllowed("ROLE_ADMIN")
    public String getAdminPage(){
        // some logic
        System.out.println("Get admin page");
        return "admin";
    }
}
