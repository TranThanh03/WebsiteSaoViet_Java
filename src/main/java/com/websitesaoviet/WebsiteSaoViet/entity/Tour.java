package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tour")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ma_tour", unique = true)
    String MaTour;

    @Column(name = "ten_tour")
    String TenTour;

    @Column(name = "anh_tour")
    String AnhTour;

    @Column(name = "gioi_thieu")
    String GioiThieu;

    @Column(name = "mo_ta")
    String MoTa;

    @Column(name = "macd")
    int MaCD;

    @Column(name = "gia_tour")
    String GiaTour;
}
