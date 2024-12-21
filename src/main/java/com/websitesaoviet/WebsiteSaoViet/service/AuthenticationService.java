package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.response.AuthenticationResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.User;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AuthenticationService {
    UserRepository userRepository;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    public AuthenticationResponse authenticate(String username, String password) {
        User user;
        if (username != null && !username.isEmpty() &&
                password != null && !password.isEmpty()
        ) {
            if (username.matches("\\d+")) {
                user = userRepository.findUserBySDT(username)
                        .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXITED));
            } else {
                user = userRepository.findUserByEmail(username)
                        .orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXITED));
            }

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

            boolean authenticated = passwordEncoder.matches(password, user.getMatkhau());

            if (!authenticated) {
                throw new AppException(ErrorCode.LOGIN_FAILE);
            }

            return AuthenticationResponse.builder()
                    .user(user)
                    .authenticated(true)
                    .build();
        } else {
            throw new AppException(ErrorCode.NOT_NULL_LOGIN);
        }
    }
}
