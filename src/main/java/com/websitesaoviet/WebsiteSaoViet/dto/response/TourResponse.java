package com.websitesaoviet.WebsiteSaoViet.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourResponse {
    String id;
    String name;
    String image;
    String introduce;
    String description;
    int categoryId;
    String price;
    LocalDateTime timeCreated;
}