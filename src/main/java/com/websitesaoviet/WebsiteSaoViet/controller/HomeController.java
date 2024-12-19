package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.entity.Guide;
import com.websitesaoviet.WebsiteSaoViet.entity.Tour;
import com.websitesaoviet.WebsiteSaoViet.service.GuideService;
import com.websitesaoviet.WebsiteSaoViet.service.TourService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HomeController {
    TourService tourService;
    GuideService guideService;

    @GetMapping("/")
    public String homePage(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());
        List<Tour> tours = tourService.getTourLatest();
        model.addAttribute("tours", tours);

        List<Guide> guides = guideService.getGuidesByEvaluate(5);
        guides.forEach(guide -> {
            LocalDate birthDate = guide.getNgaySinh();
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            guide.setTuoi(age);
        });
        model.addAttribute("guides", guides);

        return "client/home/index";
    }

    @GetMapping("/manage/index")
    public String manageIndex(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        return "admin/home/index";
    }
}
