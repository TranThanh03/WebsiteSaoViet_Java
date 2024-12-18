package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.AccountResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Account;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.mapper.AccountMapper;
import com.websitesaoviet.WebsiteSaoViet.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService {
    AccountRepository accountRepository;
    AccountMapper accountMapper;

    public Account createAccount(AccountCreationRequest request) {
        if(accountRepository.existsAccountBySdt(request.getSDT())) {
            throw new AppException(ErrorCode.PHONENUMBER_EXISTED);
        }
        else if (accountRepository.existsAccountByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }
        Account account = accountMapper.toAccount(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        account.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
        account.setQuyen("user");
        account.setSdt(request.getSDT());

        return accountRepository.save(account);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public AccountResponse getAccountById(String id) {
        return accountMapper.toAccountResponse(accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tài khoản không hợp lệ!")));
    }

    public AccountResponse updateAccount(String id, AccountUpdateRequest request) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tài khoản không hợp lệ!"));

        account.setSdt(request.getSDT());
        account.setEmail(request.getEmail());

        if(request.getMatKhau() != null && !request.getMatKhau().isEmpty()) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

            account.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
        }

        return accountMapper.toAccountResponse(accountRepository.save(account));
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
