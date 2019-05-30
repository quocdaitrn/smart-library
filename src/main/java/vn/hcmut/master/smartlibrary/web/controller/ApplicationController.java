package vn.hcmut.master.smartlibrary.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @GetMapping("/")
    public String ping() {
        return "ok";
    }
}
