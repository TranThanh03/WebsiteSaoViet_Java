package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TourCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TourUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.CategoryResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.TourResponse;
import com.websitesaoviet.WebsiteSaoViet.service.CategoryService;
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
    CategoryService categoryService;

    @PostMapping()
    ResponseEntity<ApiResponse<TourResponse>> createTour(@RequestBody TourCreationRequest request) {
        ApiResponse<TourResponse> apiResponse = ApiResponse.<TourResponse>builder()
                .code(1989)
                .message("Thêm tour mới thành công.")
                .result(tourService.createTour(request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping()
    ResponseEntity<ApiResponse<List<TourResponse>>> getTours() {
        ApiResponse<List<TourResponse>> apiResponse = ApiResponse.<List<TourResponse>>builder()
                .code(1988)
                .result(tourService.getTours())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/category")
    ResponseEntity<ApiResponse<List<CategoryResponse>>> getTourCategory() {
        ApiResponse<List<CategoryResponse>> apiResponse = ApiResponse.<List<CategoryResponse>>builder()
                .code(1987)
                .result(categoryService.getTourCategory())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<TourResponse>> getTourById(@PathVariable String id) {
        ApiResponse<TourResponse> apiResponse = ApiResponse.<TourResponse>builder()
                .code(1986)
                .result(tourService.getTourById(id))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    ResponseEntity<ApiResponse<TourResponse>> updateTour(@PathVariable String id, @RequestBody TourUpdateRequest request) {
        ApiResponse<TourResponse> apiResponse = ApiResponse.<TourResponse>builder()
                .code(1985)
                .message("Cập nhật thông tin tour thành công.")
                .result(tourService.updateTour(id, request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<String>> deleteTour(@PathVariable String id) {
        tourService.deleteTour(id);

        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1984);
        apiResponse.setMessage("Xóa tour thành công.");

        return ResponseEntity.ok(apiResponse);
    }
}