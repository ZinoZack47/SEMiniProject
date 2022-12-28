package com.ensa.glminiprojectsp.Services.Rest;

import com.ensa.glminiprojectsp.Beans.Account;
import com.ensa.glminiprojectsp.Services.MySQLConnector;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountAPI {
    @GetMapping("/accounts/{username}")
    @ResponseBody
    public Account getAccountByUserId(@PathVariable("username") String username) {
        return MySQLConnector.getInstance().findAccountByUserId(username);
    }
}
