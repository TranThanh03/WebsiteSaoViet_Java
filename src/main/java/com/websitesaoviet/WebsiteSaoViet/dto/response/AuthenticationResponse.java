package com.websitesaoviet.WebsiteSaoViet.dto.response;

import com.websitesaoviet.WebsiteSaoViet.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {
    User user;
    boolean authenticated;
}
