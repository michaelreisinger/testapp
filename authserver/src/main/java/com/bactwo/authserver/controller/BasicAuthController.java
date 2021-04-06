package com.bactwo.authserver.controller;

import com.bactwo.authserver.bean.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
@RequestMapping("/todo-api/v1")
public class BasicAuthController {
    @GetMapping("/basicauth")
    public AuthenticationBean todoAppBean() {
        return new AuthenticationBean("You are authenticated");
    }
}
