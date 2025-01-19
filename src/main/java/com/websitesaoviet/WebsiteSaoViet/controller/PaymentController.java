package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.PaymentCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.PaymentUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.PaymentResponse;
import com.websitesaoviet.WebsiteSaoViet.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentController {
    PaymentService paymentService;

    @PostMapping()
    ResponseEntity<ApiResponse<PaymentResponse>> createPayment(@RequestBody PaymentCreationRequest request) {
        ApiResponse<PaymentResponse> apiResponse = ApiResponse.<PaymentResponse>builder()
                .code(1949)
                .message("Thêm hóa đơn mới thành công.")
                .result(paymentService.createPayment(request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping()
    ResponseEntity<ApiResponse<List<PaymentResponse>>> getPayments() {
        ApiResponse<List<PaymentResponse>> apiResponse = ApiResponse.<List<PaymentResponse>>builder()
                .code(1948)
                .result(paymentService.getPayments())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<PaymentResponse>> getPaymentById(@PathVariable String id) {
        ApiResponse<PaymentResponse> apiResponse = ApiResponse.<PaymentResponse>builder()
                .code(1947)
                .result(paymentService.getPaymentById(id))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    ResponseEntity<ApiResponse<PaymentResponse>> updatePayment(@PathVariable String id, @RequestBody PaymentUpdateRequest request) {
        ApiResponse<PaymentResponse> apiResponse = ApiResponse.<PaymentResponse>builder()
                .code(1946)
                .message("Cập nhật thông tin hóa đơn thành công.")
                .result(paymentService.updatePayment(id, request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }
}