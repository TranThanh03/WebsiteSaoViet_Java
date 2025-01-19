package com.websitesaoviet.WebsiteSaoViet.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentCreationRequest {
    String orderId;
    String amount;
    String method;
}