package com.yevhenberladyniuk.debts.controller;

import com.yevhenberladyniuk.debts.dto.CreateUserForm;
import com.yevhenberladyniuk.debts.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String create(){

        return "user/new";
    }

    @PostMapping("/register")
    public String create(CreateUserForm createUserForm) {

        userService.create(createUserForm);
        return "redirect:/main";
    }
}
