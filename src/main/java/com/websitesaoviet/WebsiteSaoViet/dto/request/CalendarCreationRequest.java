package com.websitesaoviet.WebsiteSaoViet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalendarCreationRequest {
    String MaKH;
    String TenKH;
    String MaTour;
    String TenTour;
    String MaHDV;
    String TenHDV;
    String MaPC;
    LocalDate NgayKH;
    LocalDate NgayKT;
    String GiaTour;
    String GiaHDV;
    String TongTien;
    LocalDateTime ThoiGianDat;
    String TrangThai;
}
