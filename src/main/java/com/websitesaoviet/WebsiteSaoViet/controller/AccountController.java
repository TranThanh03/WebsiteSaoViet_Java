package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.AccountResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Account;
import com.websitesaoviet.WebsiteSaoViet.service.AccountService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;

    @PostMapping()
    ApiResponse<Account> createAccount(@RequestBody @Valid AccountCreationRequest request) {
        ApiResponse<Account> apiResponse = new ApiResponse<>();

        apiResponse.setResult(accountService.createAccount(request));

        return apiResponse;
    }

    @GetMapping()
    List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    AccountResponse getAccountById(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    AccountResponse updateAccount(@PathVariable String id, @RequestBody AccountUpdateRequest request) {
        return accountService.updateAccount(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteAccount(@PathVariable String id) {
        accountService.deleteAccount(id);
        String message = String.format("Xóa tài khoản thành công.");
        return ResponseEntity.ok(message);
    }
}
