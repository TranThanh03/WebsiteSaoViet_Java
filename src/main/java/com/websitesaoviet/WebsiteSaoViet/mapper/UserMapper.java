package com.websitesaoviet.WebsiteSaoViet.mapper;

import com.websitesaoviet.WebsiteSaoViet.dto.request.UserCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.UserUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.UserResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User createUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    List<UserResponse> toListUsersResponse(List<User> usersList);

    void updateUser(@MappingTarget User account, UserUpdateRequest request);
}
