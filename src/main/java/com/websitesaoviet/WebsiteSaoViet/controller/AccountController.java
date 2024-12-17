package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Account;
import com.websitesaoviet.WebsiteSaoViet.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping()
    Account createAccount(@RequestBody AccountCreationRequest request) {
        return accountService.createAccount(request);
    }

    @GetMapping()
    List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    Account getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    Account updateAccount(@PathVariable String id, @RequestBody AccountUpdateRequest request) {
        return accountService.updateAccount(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        String message = String.format("Xóa tài khoản thành công.");
        return ResponseEntity.ok(message);
    }
}
