package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Account;
import com.websitesaoviet.WebsiteSaoViet.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createRequest(AccountCreationRequest request) {
        Account account = new Account();

        account.setSDT(request.getSDT());
        account.setEmail(request.getEmail());
        account.setMatKhau(request.getMatKhau());
        account.setQuyen("user");

        return accountRepository.save(account);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(String id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tài khoản không hợp lệ!"));
    }

    public Account updateAccount(String id, AccountUpdateRequest request) {
        Account account = getAccountById(id);

        account.setSDT(request.getSDT());
        account.setEmail(request.getEmail());

        if(request.getMatKhau() != null && !request.getMatKhau().isEmpty()) {
            account.setMatKhau(request.getMatKhau());
        }

        return accountRepository.save(account);
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
