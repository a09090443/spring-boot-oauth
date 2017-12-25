package com.localhost.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/api/test1")
    public String test1() {
        return "This is test1";
    }

	@GetMapping("/api/test2")
    public String test2() {
        return "This is test2";
    }

}
