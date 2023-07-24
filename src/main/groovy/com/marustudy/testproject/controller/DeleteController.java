package com.marustudy.testproject.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "DELETE 메소드 TEST")
@RestController
@RequestMapping(value = "/api/v1/delete-api")
public class DeleteController {
    // http://localhost:8080//api/v1/delete-api/delete/{String}
    @DeleteMapping(value = "/delete/{varialbe}")
    public String DeleteVarialbe(@PathVariable String varialbe){
        return varialbe;
    }
}
