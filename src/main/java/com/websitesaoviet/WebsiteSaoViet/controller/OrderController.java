package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.OrderCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.OrderUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.OrderResponse;
import com.websitesaoviet.WebsiteSaoViet.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {
    OrderService orderService;

    @PostMapping()
    ResponseEntity<ApiResponse<OrderResponse>> createOrder(@RequestBody OrderCreationRequest request) {
        ApiResponse<OrderResponse> apiResponse = ApiResponse.<OrderResponse>builder()
                .code(1959)
                .message("Thêm lịch đặt mới thành công.")
                .result(orderService.createOrder(request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping()
    ResponseEntity<ApiResponse<List<OrderResponse>>> getOrders() {
        ApiResponse<List<OrderResponse>> apiResponse = ApiResponse.<List<OrderResponse>>builder()
                .code(1958)
                .result(orderService.getOrders())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<OrderResponse>> getOrderById(@PathVariable String id) {
        ApiResponse<OrderResponse> apiResponse = ApiResponse.<OrderResponse>builder()
                .code(1957)
                .result(orderService.getOrderById(id))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    ResponseEntity<ApiResponse<OrderResponse>> updateOrder(@PathVariable String id, @RequestBody OrderUpdateRequest request) {
        ApiResponse<OrderResponse> apiResponse = ApiResponse.<OrderResponse>builder()
                .code(1956)
                .message("Cập nhật thông tin lịch đặt thành công.")
                .result(orderService.updateOrder(id, request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }
}