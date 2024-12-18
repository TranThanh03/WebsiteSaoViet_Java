package com.websitesaoviet.WebsiteSaoViet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCreationRequest {
    String MaTour;
    String MaHDV;
    String GiaHDV;
    LocalDate NgayKH;
    LocalDate NgayKT;
    String TrangThai;
}
