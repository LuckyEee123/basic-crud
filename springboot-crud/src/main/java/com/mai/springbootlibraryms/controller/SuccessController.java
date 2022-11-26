package com.mai.springbootlibraryms.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuccessController {

    @RequestMapping("/")
    public String health() {
        return "SUCCESS!";
    }

}
