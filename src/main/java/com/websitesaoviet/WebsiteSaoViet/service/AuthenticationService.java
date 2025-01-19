package com.websitesaoviet.WebsiteSaoViet.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.websitesaoviet.WebsiteSaoViet.dto.request.AuthenticationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.IntrospectRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.AuthenticationResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.IntrospectResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.User;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
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

            boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());

            if(!authenticated) {
                throw new AppException(ErrorCode.UNAUTHENTICATED);
            }

            var token = generateToken(request.getUsername());

            return AuthenticationResponse.builder()
                    .token(token)
                    .authenticated(true)
                    .build();
        } else {
            throw new AppException(ErrorCode.NOT_NULL_LOGIN);
        }
    }

    private String generateToken(String username) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("saoviet.com")
                .issueTime(new Date())
                .expirationTime(Date.from(
                        Instant.now().plusSeconds(3600)
                ))
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));

            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }

    public IntrospectResponse introspect(IntrospectRequest request)
            throws JOSEException, ParseException {
        var token = request.getToken();

        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expityTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified= signedJWT.verify(verifier);

        return IntrospectResponse.builder()
                .valid(verified && expityTime.after(new Date()))
                .build();
    }
}
