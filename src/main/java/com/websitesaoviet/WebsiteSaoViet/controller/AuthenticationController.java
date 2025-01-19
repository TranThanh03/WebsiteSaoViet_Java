package com.websitesaoviet.WebsiteSaoViet.controller;

import com.nimbusds.jose.JOSEException;
import com.websitesaoviet.WebsiteSaoViet.dto.request.AuthenticationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.IntrospectRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.AuthenticationResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.IntrospectResponse;
import com.websitesaoviet.WebsiteSaoViet.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder()
                .code(result.isAuthenticated() ? 1000 : 9999)
                .result(AuthenticationResponse.builder()
                        .token(result.getToken())
                        .authenticated(result.isAuthenticated())
                        .build())
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspectToken(@RequestBody IntrospectRequest request)
                throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);

        return ApiResponse.<IntrospectResponse>builder()
                .code(result.isValid() ? 1000 : 9998)
                .result(result)
                .build();
    }
}