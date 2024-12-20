package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Guide;
import com.websitesaoviet.WebsiteSaoViet.service.GuideService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("/guides")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GuideController {
    GuideService guideService;

    @PostMapping()
    Guide createGuide(@RequestBody GuideCreationRequest request) {
        return guideService.createGuide(request);
    }

    @GetMapping("/index")
    public String getGuides(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        List<Guide> guides = guideService.getGuides();
        guides.forEach(guide -> {
            LocalDate birthDate = guide.getNgaysinh();
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            guide.setTuoi(age);
        });
        model.addAttribute("guides", guides);

        return "client/guide/index";
    }

    @GetMapping("/detail/{id}")
    public String getGuideById(@PathVariable String id, HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        Guide guide = guideService.getGuideById(id);
        LocalDate birthDate = guide.getNgaysinh();
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        guide.setTuoi(age);
        model.addAttribute("guide", guide);

        return "client/guide/detail";
    }

    @PutMapping("/{id}")
    Guide updateGuide(@PathVariable String id, @RequestBody GuideUpdateRequest request) {
        return guideService.updateAccount(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteGuide(@PathVariable String id) {
        guideService.deleteGuide(id);
        String message = String.format("Xóa hướng dẫn viên thành công.");
        return ResponseEntity.ok(message);
    }
}
