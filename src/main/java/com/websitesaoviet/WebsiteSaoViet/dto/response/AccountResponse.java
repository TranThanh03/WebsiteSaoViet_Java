package com.websitesaoviet.WebsiteSaoViet.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse {
    String MaTK;
    String SDT;
    String Email;
    String MatKhau;
    String Quyen;
}
