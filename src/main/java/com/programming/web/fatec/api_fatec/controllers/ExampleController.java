package com.programming.web.fatec.api_fatec.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    
    @GetMapping
    public String HelloWorldDefault(){
        return "hello";
    }

    @GetMapping("{name}")
    public String HelloWorld(@PathVariable Optional<String> name){
        return name.isPresent() ? name.get() : "default";
    }

}
