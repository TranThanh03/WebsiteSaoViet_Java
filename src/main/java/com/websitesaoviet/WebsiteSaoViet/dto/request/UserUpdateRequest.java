package com.websitesaoviet.WebsiteSaoViet.dto.request;

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
    String tenkh;

    @Pattern(regexp = "\\d{10}", message = "PHONENUMBER_INVALID")
    String sdt;

    String email;

    @Size(min = 8, message = "PASSWORD_INVALID")
    String matkhau;
}
