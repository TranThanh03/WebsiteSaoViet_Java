package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Guide;
import com.websitesaoviet.WebsiteSaoViet.service.GuideService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guides")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GuideController {
    GuideService guideService;

    @PostMapping()
    Guide createGuide(@RequestBody GuideCreationRequest request) {
        return guideService.createGuide(request);
    }

    @GetMapping()
    List<Guide> getGuides() {
        return guideService.getGuides();
    }

    @GetMapping("/{id}")
    Guide getGuideById(@PathVariable String id) {
        return guideService.getGuideById(id);
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
