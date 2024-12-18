package com.websitesaoviet.WebsiteSaoViet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuideCreationRequest {
    String TenHDV;
    String AnhHDV;
    String GioiTinh;
    LocalDate NgaySinh;
    String SDT;
    String Email;
    String MoTa;
    int DanhGia;
}
