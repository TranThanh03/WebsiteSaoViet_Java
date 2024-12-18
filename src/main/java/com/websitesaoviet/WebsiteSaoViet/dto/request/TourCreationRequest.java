package com.websitesaoviet.WebsiteSaoViet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourCreationRequest {
    String TenTour;
    String AnhTour;
    String GioiThieu;
    String MoTa;
    int MaCD;
    String GiaTour;
}
