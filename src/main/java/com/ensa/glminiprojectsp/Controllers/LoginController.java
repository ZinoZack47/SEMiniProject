package com.ensa.glminiprojectsp.Controllers;
import com.ensa.glminiprojectsp.Beans.Account;

import com.ensa.glminiprojectsp.Utils.APIGetSet;
import com.ensa.glminiprojectsp.Utils.PasswordHash;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "redirect:/Dashboard";
        }
        return "login";
    }
    @PostMapping("/login")
    public String submit_login(@RequestParam String username,
                               @RequestParam String passwordField,
                               HttpSession session,
                               Model model) {
        char[] password = passwordField.toCharArray();

        Account account = APIGetSet.getObject("/api/accounts/"+username, Account.class);
        if (account == null || !PasswordHash.getInstance().verifyPassword(password, account.getHashedPassword()))
        {
            model.addAttribute("invalid", true);
            return "login";
        }
        session.setAttribute("user", account);
        session.setMaxInactiveInterval(3600);
        return "redirect:/Dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }

    public static boolean VerifySession(HttpSession session) {
        Account account = (Account)session.getAttribute("user");
        return account != null && account.isAdmin();
    }
}
