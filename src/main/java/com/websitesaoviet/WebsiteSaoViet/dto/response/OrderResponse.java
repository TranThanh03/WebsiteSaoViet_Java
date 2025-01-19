package com.websitesaoviet.WebsiteSaoViet.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponse {
    String userId;
    String userName;
    String tourId;
    String tourName;
    String guideId;
    String guideName;
    String assignmentId;
    LocalDate startDate;
    LocalDate endDate;
    String tourPrice;
    String guidePrice;
    int numberOfPeople;
    String totalPrice;
    LocalDateTime oderDatetime;
    String status;
}