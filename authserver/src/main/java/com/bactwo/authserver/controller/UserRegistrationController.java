package com.bactwo.authserver.controller;

import com.bactwo.authserver.dto.UserDTO;
import com.bactwo.authserver.service.UserService;
import com.bactwo.authserver.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/registration")
public class UserRegistrationController {

        private final UserService userService;

        @Autowired
        public UserRegistrationController(UserServiceImpl userService) {
            this.userService = userService;
        }


        @ModelAttribute("user")
        public UserDTO UserDTO()
        {
            return new UserDTO();
        }

        @GetMapping
        public String showRegistrationForm()
        {
            return "user/registration";
        }

        @PostMapping
        public String registerUserAccount(@ModelAttribute("user") UserDTO registrationDTO)
        {
            userService.save(registrationDTO);
            return "redirect:/user/registration?success";
        }

    }