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
public class AccountCreationRequest {
    @Pattern(regexp = "\\d{10}", message = "PHONENUMBER_INVALID")
    String SDT;
    String Email;
    
    @Size(min = 8, message = "PASSWORD_INVALID")
    String MatKhau;
    String Quyen = "user";
}
