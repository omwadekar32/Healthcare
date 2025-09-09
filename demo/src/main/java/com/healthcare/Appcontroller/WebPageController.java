package com.healthcare.Appcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {

    @GetMapping("/")
    public String Login() {
        return "redirect:/login.html";
    }
}
