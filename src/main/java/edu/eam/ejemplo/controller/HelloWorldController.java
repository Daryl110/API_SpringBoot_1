package edu.eam.ejemplo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/say")
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World from controller in Spring Boot";
    }

    @GetMapping("/helloW")
    public String helloWithName(
            @RequestParam(
                    name = "name",
                    required = false,
                    defaultValue = "My Friend"
            ) String name
    ){
        return "Hello "+name+" from controller in Spring Boot";
    }

    @RequestMapping(
            path = "/helloWh/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String helloWithName1(@PathVariable("name") String name){
        return "Hello "+name+" from controller in Spring Boot";
    }
}
