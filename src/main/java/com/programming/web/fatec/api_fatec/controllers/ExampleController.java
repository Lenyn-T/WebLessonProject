package com.programming.web.fatec.api_fatec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    
    @GetMapping
    public String HelloWorldDefault(){
        return "hello, welcome to these testing grounds.";
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
    public String EvenOdd(@PathVariable String evodd){
        
        try {
            Integer result = Integer.parseInt(evodd);
            
            if(result % 2 == 0){
                return "The number " + evodd + " is Even";
            }else if (result % 2 != 0) {
                return "The number " + evodd + " is Odd";
            }else{
                return "Invalid number.";
            }
        } catch (NumberFormatException e) {
            return "Invalid number.";
        }
    }

    @GetMapping("/bodymassindex/{bmiheight}/{bmiweight}")
    public String BodyMassIndex(@PathVariable String bmiheight, @PathVariable String bmiweight){
        try {
            Double tometers = Double.parseDouble(bmiheight) / 100;
            Double bmiresult;
            bmiresult = Integer.parseInt(bmiweight) / (tometers*tometers);
            if (bmiresult < 18.5) {
                return "Underweight at bmi "+bmiresult;
            }else if (bmiresult >= 18.5 && bmiresult <= 24.9) {
                return "Regular weight at bmi "+bmiresult;
            }else if (bmiresult >= 25 && bmiresult <= 29.9) {
                return "Overweight at bmi "+bmiresult;
            }else if (bmiresult >= 30 && bmiresult <= 34.9) {
                return "1st grade Obesity at bmi "+bmiresult;
            }else if (bmiresult >= 35 && bmiresult <= 39.9) {
                return "2nd grade Obesity at bmi "+bmiresult;
            }else{
                return "3rd grade Obesity at bmi "+bmiresult;
            }
        } catch (NumberFormatException e) {
            return "Invalid Data.";
        }
    }
}
