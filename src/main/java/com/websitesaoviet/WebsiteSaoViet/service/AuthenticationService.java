package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AuthenticationRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.User;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.repository.UserRepository;
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
    UserRepository userRepository;

    public boolean authenticate(AuthenticationRequest request) {
        User user;

        if (request.getUsername() != null && !request.getUsername().isEmpty() &&
                request.getPassword() != null && !request.getPassword().isEmpty()
        ) {
            if (request.getUsername().matches("\\d+")) {
                user = userRepository.findUserByPhone(request.getUsername())
                        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXITED));
            } else {
                user = userRepository.findUserByEmail(request.getUsername())
                        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXITED));
            }

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

            return passwordEncoder.matches(request.getPassword(), user.getPassword());
        } else {
            throw new AppException(ErrorCode.NOT_NULL_LOGIN);
        }
    }
}
