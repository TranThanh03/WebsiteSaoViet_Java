package com.websitesaoviet.WebsiteSaoViet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GuideUpdateRequest {
    String tenhdv;
    String anhhdv;
    String gioitinh;
    LocalDate ngaysinh;
    String sdt;
    String mmail;
    String mota;
    int danhgia;
}
