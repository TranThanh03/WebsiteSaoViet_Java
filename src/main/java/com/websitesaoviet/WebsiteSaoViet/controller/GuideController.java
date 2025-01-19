package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.GuideResponse;
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
    ResponseEntity<ApiResponse<GuideResponse>> createGuide(@RequestBody GuideCreationRequest request) {
        ApiResponse<GuideResponse> apiResponse = ApiResponse.<GuideResponse>builder()
                .code(1969)
                .message("Thêm hướng dẫn viên mới thành công.")
                .result(guideService.createGuide(request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping()
    ResponseEntity<ApiResponse<List<GuideResponse>>> getGuides() {
        ApiResponse<List<GuideResponse>> apiResponse = ApiResponse.<List<GuideResponse>>builder()
                .code(1968)
                .result(guideService.getGuides())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<GuideResponse>> getGuideById(@PathVariable String id) {
        ApiResponse<GuideResponse> apiResponse = ApiResponse.<GuideResponse>builder()
                .code(1967)
                .result(guideService.getGuideById(id))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    ResponseEntity<ApiResponse<GuideResponse>> updateGuide(@PathVariable String id, @RequestBody GuideUpdateRequest request) {
        ApiResponse<GuideResponse> apiResponse = ApiResponse.<GuideResponse>builder()
                .code(1966)
                .message("Cập nhật thông tin hướng dẫn viên thành công.")
                .result(guideService.updateGuide(id, request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<String>> deleteGuide(@PathVariable String id) {
        guideService.deleteGuide(id);

        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1965);
        apiResponse.setMessage("Xóa hướng dẫn viên thành công.");

        return ResponseEntity.ok(apiResponse);
    }
}