package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TourCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TourUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Tour;
import com.websitesaoviet.WebsiteSaoViet.service.TourService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TourController {
    TourService tourService;

    @PostMapping()
    Tour createTour(@RequestBody TourCreationRequest request) {
        return tourService.createTour(request);
    }

    @GetMapping()
    List<Tour> getTours() {
        return tourService.getTours();
    }

    @GetMapping("/{id}")
    Tour getTourById(@PathVariable String id) {
        return tourService.getTourById(id);
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
