package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.service.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AuthenticationController {
    AuthenticationService authenticationService;
    ApiResponse apiResponse = new ApiResponse();

    @GetMapping("/login")
    public String login() {
        return "client/auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "client/auth/register";
    }

    @PostMapping("/token")
    public String authenticate(@RequestParam String username, @RequestParam String password, Model model, RedirectAttributes redirectAttributes, HttpServletResponse response) {
        try {
            var result = authenticationService.authenticate(username, password);

            if (result.isAuthenticated()) {
                Cookie cookie = new Cookie("idUser", result.getUser().getMakh());
                cookie.setHttpOnly(false);
                cookie.setSecure(true);
                cookie.setPath("/");
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);

                if (username.equals("admin@gmail.com")) {
                    return "redirect:/manage/index";
                }

                return "redirect:/";
            }

            throw new AppException(ErrorCode.ACCOUNT_NOT_EXITED);

        } catch (AppException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", ex.getErrorCode().getMessage());
            redirectAttributes.addFlashAttribute("username", username);
            redirectAttributes.addFlashAttribute("password", password);

            return "redirect:/auth/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("idUser", "");
        cookie.setHttpOnly(false);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return "redirect:/";
    }
}