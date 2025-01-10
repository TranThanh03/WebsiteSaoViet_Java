package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.UserCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.UserUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.UserResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.User;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.mapper.UserMapper;
import com.websitesaoviet.WebsiteSaoViet.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request) {
        if(userRepository.existsUserByPhone(request.getPhone())) {
            throw new AppException(ErrorCode.PHONENUMBER_EXISTED);
        }
        if (userRepository.existsUserByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }

        User user = userMapper.createUser(request);

        user.setId(String.valueOf(generateNextId()));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("user");

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<UserResponse> getUsers() {
        return userMapper.toListUsersResponse(userRepository.findAll());
    }

    public UserResponse getUserById(String id) {
        return  userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXITED)));
    }

    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXITED));

        if (user == null) {
            throw new AppException(ErrorCode.USER_NOT_EXITED);
        }

        if(userRepository.existsUserByPhone(request.getPhone()) && !user.getPhone().equals(request.getPhone())) {
            throw new AppException(ErrorCode.PHONENUMBER_EXISTED);
        }
        if (userRepository.existsUserByEmail(request.getEmail()) && !user.getEmail().equals(request.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }

        if(request.getPassword() != null && !request.getPassword().isEmpty()) {
            userMapper.updateUser(user, request);

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        else {
            user.setFullName(request.getFullName());
            user.setPhone(request.getPhone());
            user.setEmail(request.getEmail());
        }

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            throw new AppException(ErrorCode.USER_NOT_EXITED);
        }

        userRepository.deleteById(id);
    }

    public String generateNextId() {
        String maxId = userRepository.findMaxId();
        if (maxId == null) {
            return "KH250001";
        }

        int currentMax = Integer.parseInt(maxId.substring(2));
        int nextId = currentMax + 1;
        return "KH" + nextId;
    }
}