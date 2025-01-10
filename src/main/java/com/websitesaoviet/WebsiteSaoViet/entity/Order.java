package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "order")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @Column(name = "id", unique = true)
    String id;

    @Column(name = "user_id")
    String userId;

    @Column(name = "user_name")
    String userName;

    @Column(name = "tour_id")
    String tourId;

    @Column(name = "tour_name")
    String tourName;

    @Column(name = "guide_id")
    String guideId;

    @Column(name = "guide_name")
    String guideName;

    @Column(name = "assignment_id")
    String assignmentId;

    @Column(name = "start_date")
    LocalDate startDate;

    @Column(name = "end_date")
    LocalDate endDate;

    @Column(name = "tour_price")
    String tourPrice;

    @Column(name = "guide_price")
    String guidePrice;

    @Column(name = "number_of_people")
    int numberOfPeople;

    @Column(name = "total_price")
    String totalPrice;

    @Column(name = "oder_datetime")
    LocalDateTime oderDatetime;

    @Column(name = "status")
    String status;
}
