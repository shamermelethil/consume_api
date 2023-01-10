package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestHelloController {
    @RequestMapping(value ="/test", method = RequestMethod.GET)
    public ResponseEntity<String > sayHello(){

        return new ResponseEntity<String>("Test Hello", HttpStatus.OK);

    }
}
