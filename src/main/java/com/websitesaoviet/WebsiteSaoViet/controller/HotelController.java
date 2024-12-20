package com.websitesaoviet.WebsiteSaoViet.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels")
public class HotelController {

    @GetMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        return "client/hotel/index";
    }

    @GetMapping("/detail")
    public String detail(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        return "client/hotel/detail";
    }
}
