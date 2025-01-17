package com.websitesaoviet.WebsiteSaoViet.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuideUpdateRequest {
    String fullName;
    String avatar;
    String sex;
    LocalDate dateOfBirth;

    @Pattern(regexp = "\\d{10}", message = "PHONENUMBER_INVALID")
    String phone;

    @Email(message = "EMAIL_INVALID")
    String email;
    String description;
    int evaluate;
}