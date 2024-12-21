package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.response.ApiResponse;
import com.websitesaoviet.WebsiteSaoViet.dto.response.UserResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.User;
import com.websitesaoviet.WebsiteSaoViet.service.UserService;
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

//    @PostMapping()
//    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
//        ApiResponse<User> apiResponse = new ApiResponse<>();
//
//        apiResponse.setResult(userService.createUser(request));
//
//        return apiResponse;
//    }

    @GetMapping()
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    ApiResponse<UserResponse> getUserById(@PathVariable String id) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUserById(id))
                .build();
    }

//    @GetMapping("/myInfor")
//    ApiResponse<UserResponse> getMyInfor() {
//        return ApiResponse.<UserResponse>builder()
//                .result(userService.getMyInfor())
//                .build();
//    }

//    @PutMapping("/{id}")
//    ApiResponse<UserResponse> updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request) {
//        return ApiResponse.<UserResponse>builder()
//                .result(userService.updateUser(id, request))
//                .build();
//    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteAccount(@PathVariable String id) {
        userService.deleteUser(id);
        String message = String.format("Xóa tài khoản thành công.");
        return ResponseEntity.ok(message);
    }
}
