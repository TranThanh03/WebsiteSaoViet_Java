package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.UserCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.UserUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.UserResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.User;
import com.websitesaoviet.WebsiteSaoViet.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping()
    ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse>builder()
                .code(1099)
                .message("Thêm khách hàng mới thành công.")
                .result(userService.createUser(request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping()
    ResponseEntity<ApiResponse<List<UserResponse>>> getUsers() {
        ApiResponse<List<UserResponse>> apiResponse = ApiResponse.<List<UserResponse>>builder()
                .code(1098)
                .result(userService.getUsers())
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable String id) {
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse>builder()
                .code(1097)
                .result(userService.getUserById(id))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    ResponseEntity<ApiResponse<UserResponse>> updateUser(@PathVariable String id, @RequestBody @Valid UserUpdateRequest request) {
        ApiResponse<UserResponse> apiResponse = ApiResponse.<UserResponse>builder()
                .code(1096)
                .message(String.format("Cập nhật thông tin khách hàng %s thành công.", id))
                .result(userService.updateUser(id, request))
                .build();

        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);

        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1095);
        apiResponse.setMessage(String.format("Xóa khách hàng %s thành công.", id));

        return ResponseEntity.ok(apiResponse);
    }
}