package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TourCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TourUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Tour;
import com.websitesaoviet.WebsiteSaoViet.service.TourService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tours")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TourController {
    TourService tourService;

    @PostMapping()
    Tour createTour(@RequestBody TourCreationRequest request) {
        return tourService.createTour(request);
    }

    @GetMapping("")
    public String getTours(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        return "client/tour/index";
    }

    @GetMapping("/index")
    public String getListTours(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        List<Tour> tours = tourService.getTours();
        model.addAttribute("tours", tours);

        return "client/tour/list";
    }

    @GetMapping("/list/{id}")
    public String getListToursByTopic(@PathVariable int id, HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        List<Tour> tours = tourService.getToursByTopic(id);
        model.addAttribute("tours", tours);

        return "client/tour/list";
    }

    @GetMapping("/manage/index")
    public String getListToursManagement(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        List<Tour> tours = tourService.getTours();
        model.addAttribute("tours", tours);

        return "admin/tour/index";
    }

    @GetMapping("/detail/{id}")
    public String getTourById(@PathVariable String id, HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        Tour tour = tourService.getTourById(id);
        model.addAttribute("tour", tour);

        return "client/tour/detail";
    }

    @PutMapping("/{id}")
    Tour updateTour(@PathVariable String id, @RequestBody TourUpdateRequest request) {
        return tourService.updateTour(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTour(@PathVariable String id) {
        tourService.deleteTour(id);
        String message = String.format("Xóa Tour thành công.");
        return ResponseEntity.ok(message);
    }
}
