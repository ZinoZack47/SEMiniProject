package com.ensa.glminiprojectsp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String Welcome() {
        return "redirect:/login";
    }

}
