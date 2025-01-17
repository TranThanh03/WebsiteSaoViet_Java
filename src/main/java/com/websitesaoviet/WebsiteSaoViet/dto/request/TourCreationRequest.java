package com.websitesaoviet.WebsiteSaoViet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourCreationRequest {
    String name;
    String image;
    String introduce;
    String description;
    int categoryId;
    String price;
}