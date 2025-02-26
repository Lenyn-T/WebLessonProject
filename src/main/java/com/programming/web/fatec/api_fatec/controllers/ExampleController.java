package com.programming.web.fatec.api_fatec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    
    @GetMapping
    public String HelloWorldDefault(){
        return "hello, welcome to this testing grounds.";
    }

    @GetMapping("{age}")
    public String CheckAge(Integer age){
        if (age <= 12 && age >= 0) {
            return "The informed age is that of a CHILD.";
        }
        else if (age > 12 && age < 18) {
            return "The informed age is that of a TEENAGER.";
        }
        else if (age < 0 && age > 130) {
            return "Please inform an age of a living person.";
        }
        else{
            return "The informed age is that of an ADULT.";
        }
    }

}
