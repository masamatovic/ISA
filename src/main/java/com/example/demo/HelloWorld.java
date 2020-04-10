package com.example.demo;

import jdk.net.SocketFlow;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/pozdrav")
public class HelloWorld {

   @GetMapping(value = "/masa")
    public ResponseEntity<String> pozdrav(){
        String ime = "masa";
        return new ResponseEntity<>(ime, HttpStatus.OK) ;
    }

}
