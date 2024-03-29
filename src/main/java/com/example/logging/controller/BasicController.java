package com.example.logging.controller;

import com.example.logging.service.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BasicService basicService;

    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok().body("welcome");
    }

    @GetMapping("/exp")
    public ResponseEntity<String> power() {
        return ResponseEntity.ok().body(basicService.power());
    }

    @GetMapping("/errors")
    public ResponseEntity<String> errors() {
        try {
            throw new Exception("EXCEPTION");

        } catch (Exception e) {
            logger.error("Error: ", e);
        }
        return ResponseEntity.ok().body("Error thrown");
    }

}
