package com.websitesaoviet.WebsiteSaoViet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourCreationRequest {
    String tentour;
    String anhtour;
    String gioithieu;
    String mota;
    int macd;
    String giatour;
}
