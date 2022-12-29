package com.ensa.glminiprojectsp.Controllers;

import com.ensa.glminiprojectsp.Beans.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class DashboardController {
    @GetMapping("/Dashboard")
    public String dashboard(HttpSession session) {
        Account account = (Account)session.getAttribute("user");
        if (account == null) {
            return "redirect:/login";
        }

        else if (account.isAdmin())
            return "admin_dashboard";

        return "professor_dashboard";
    }
}
