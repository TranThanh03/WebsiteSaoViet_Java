package com.websitesaoviet.WebsiteSaoViet.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssignmentResponse {
    String id;
    String tourId;
    String guideId;
    LocalDate startDate;
    LocalDate endDate;
    int numberOfPeople;
    String guidePrice;
    String status;
}