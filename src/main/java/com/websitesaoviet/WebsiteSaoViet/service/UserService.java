package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.UserCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.UserUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.User;
import com.websitesaoviet.WebsiteSaoViet.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        user.setTenKH(request.getTenKH());
        user.setMaTK(request.getMaTK());

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khách hàng không hợp lệ!"));
    }

    public User updateUser(String id, UserUpdateRequest request) {
        User user = getUserById(id);

        user.setTenKH(request.getTenKH());

        return userRepository.save(user);
    }

    public void deleteAccount(String id) {
        userRepository.deleteById(id);
    }
}
