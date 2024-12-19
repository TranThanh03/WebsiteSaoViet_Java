package com.websitesaoviet.WebsiteSaoViet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/news")
public class NewController {

    @GetMapping()
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        return "client/news/index";
    }

    @GetMapping("/detail")
    public String detail(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());
        
        return "client/news/detail";
    }
}
