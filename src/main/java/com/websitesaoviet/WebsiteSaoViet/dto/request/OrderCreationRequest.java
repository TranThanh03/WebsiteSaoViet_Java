package com.websitesaoviet.WebsiteSaoViet.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderCreationRequest {
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

    @Min(value = 1, message = "PEOPLE_INVALID")
    int numberOfPeople;
    String totalPrice;
}