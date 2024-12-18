package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AuthenticationRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Account;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    AccountRepository accountRepository;

    public boolean authenticate(AuthenticationRequest request) {
        Account account;
        if (request.getUsername() != null && !request.getUsername().isEmpty() &&
                request.getPassword() != null && !request.getPassword().isEmpty()
        ) {
            if (request.getUsername().matches("\\d+")) {
                account = accountRepository.findAccountBySdt(request.getUsername())
                        .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXITED));
            } else {
                account = accountRepository.findAccountByEmail(request.getUsername())
                        .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXITED));
            }

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

            return passwordEncoder.matches(request.getPassword(), account.getMatKhau());
        } else {
            throw new AppException(ErrorCode.NOT_NULL_LOGIN);
        }
    }
}
