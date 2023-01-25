package com.start.mavenbook.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafController {
    @GetMapping(value = "/main")
    public String thymeleaf(Model model) {
        model.addAttribute("data", "타임리프");
        return "thymeleaf/index";
    }
}
