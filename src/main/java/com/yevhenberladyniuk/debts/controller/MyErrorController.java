package com.yevhenberladyniuk.debts.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @GetMapping("/error")
    public String handleError(Model model, HttpServletRequest req){

        Integer errorCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) req.getAttribute("javax.servlet.error.exception");

        model.addAttribute("errorCode", errorCode);

        if (exception != null) {
            model.addAttribute("errorMessage", exception.getMessage());
        }
        return "error/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
