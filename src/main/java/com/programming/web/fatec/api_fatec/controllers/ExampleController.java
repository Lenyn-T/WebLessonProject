package com.programming.web.fatec.api_fatec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    
    @GetMapping("")
    public String HelloWorld(){
        return "hello";
    }

}
