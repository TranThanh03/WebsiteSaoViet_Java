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
    String makh;
    String tenkh;
    String matour;
    String tentour;
    String mahdv;
    String tenhdv;
    String mapc;
    LocalDate ngaykh;
    LocalDate ngaykt;
    String giatour;
    String giahdv;
    String tongtien;
    LocalDateTime thoigiandat;
    String trangthai;
}
