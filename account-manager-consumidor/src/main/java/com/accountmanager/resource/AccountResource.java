package com.accountmanager.resource;

import com.accountmanager.domain.Account;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountResource {

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account){

        System.out.println(account.getUsername());
        System.out.println(account.getEmail());
        System.out.println(account.getPassword());

        return account;
    }
}
