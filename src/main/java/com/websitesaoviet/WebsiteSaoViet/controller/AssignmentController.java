package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AssignmentCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.AssignmentResponse;
import com.websitesaoviet.WebsiteSaoViet.service.AssignmentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AssignmentController {
    AssignmentService assignmentService;

    @PostMapping()
    ResponseEntity<ApiResponse<AssignmentResponse>> createAssignment(@RequestBody @Valid AssignmentCreationRequest request) {
        ApiResponse<AssignmentResponse> apiResponse = ApiResponse.<AssignmentResponse>builder()
                .code(1079)
                .message("Thêm lịch phân công mới thành công.")
                .result(assignmentService.createAssignment(request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping()
    ResponseEntity<ApiResponse<List<AssignmentResponse>>> getAssignments() {
        ApiResponse<List<AssignmentResponse>> apiResponse = ApiResponse.<List<AssignmentResponse>>builder()
                .code(1078)
                .result(assignmentService.getAssignments())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<String>> deleteAssignment(@PathVariable String id) {
        assignmentService.deleteAssignment(id);

        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1077);
        apiResponse.setMessage(String.format("Xóa lịch phân công %s thành công.", id));

        return ResponseEntity.ok(apiResponse);
    }
}