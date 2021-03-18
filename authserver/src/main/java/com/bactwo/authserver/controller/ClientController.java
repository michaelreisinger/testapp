package com.bactwo.authserver.controller;

import com.bactwo.authserver.service.UserServiceImpl;
import com.bactwo.authserver.service.ToDoListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private final UserServiceImpl userServiceImpl;

    private final ToDoListServiceImpl toDoListServiceImpl;

    @Autowired
    public ClientController(UserServiceImpl userServiceImpl, ToDoListServiceImpl toDoListServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.toDoListServiceImpl = toDoListServiceImpl;
    }
}
