package com.websitesaoviet.WebsiteSaoViet.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssignmentCreationRequest {
    String tourId;
    String guideId;

    @NotNull(message = "STARTDATE_NOT_NULL")
    @JsonFormat(pattern = "MM/dd/yyyy")
    LocalDate startDate;

    @NotNull(message = "ENDDATE_NOT_NULL")
    @JsonFormat(pattern = "MM/dd/yyyy")
    LocalDate endDate;

    @Min(value = 1, message = "PEOPLE_INVALID")
    int numberOfPeople;
    String guidePrice;
}