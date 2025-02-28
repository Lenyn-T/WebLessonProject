package com.programming.web.fatec.api_fatec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    
    @GetMapping
    public String HelloWorldDefault(){
        return "hello, welcome to this testing grounds.";
    }

    @GetMapping("{name}")
    public String HelloWorld(@PathVariable String name){
        return "Hello, " + name;
    }

    @GetMapping("/getage/{age}")
    public String CheckAge(@PathVariable Integer age){
        try {
            if (age <= 12 && age >= 0) {
                return "The informed age is that of a CHILD.";
            }
            else if (age > 12 && age < 18) {
                return "The informed age is that of a TEENAGER.";
            }
            else if (age < 0 || age > 130) {
                return "Please inform an age of a living person.";
            }
            else{
                return "The informed age is that of an ADULT.";
            }
        } catch (Exception e) {
            return "Incorrect value applied.";
        }
    }

    @GetMapping("/evenodd/{evodd}")
    public String EvenOdd(@PathVariable Integer evodd){
        try {
            if(evodd % 2 == 0){
                return "The number " + evodd + " is Even";
            }else if (evodd % 2 != 0) {
                return "The number " + evodd + " is Odd";
            }else{
                return "Invalid number.";
            }
        } catch (Exception e) {
            return "Invalid number.";
        }
    }

    @GetMapping("/bodmassindex/{bmiheight}/{bmiweight}")
    public String BodyMassIndex(@PathVariable Integer bmiheight, Integer bmiweight){
        Double bmiresult = bmiweight / Math.pow(bmiheight, 2);
        try {
            if (bmiresult < 18.5) {
                return "Underweight.";
            }else if (bmiresult > 18.5 && bmiresult < 25) {
                return "Regular weight.";
            }else if (bmiresult >= 25 && bmiresult < 30) {
                return "Overweight";
            }else if (bmiresult >= 30 && bmiresult < 35) {
                return "1st grade Obesity";
            }else if (bmiresult >= 35 && bmiresult < 40) {
                return "2nd grade Obesity";
            }else {
                return "3rd grade Obesity";
            }
        } catch (Exception e) {
            return "Invalid Data.";
        }
    }
}
