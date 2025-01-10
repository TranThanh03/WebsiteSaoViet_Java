package com.websitesaoviet.WebsiteSaoViet.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    String fullName;

    @Pattern(regexp = "\\d{10}", message = "PHONENUMBER_INVALID")
    String phone;

    @Email(message = "EMAIL_INVALID")
    String email;

    @Pattern(regexp = "^.{8,}$|^$", message = "PASSWORD_INVALID")
    String password;
}