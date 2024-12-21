package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

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
    String matour;

    @Column(name = "ten_tour")
    String tentour;

    @Column(name = "anh_tour")
    String anhtour;

    @Column(name = "gioi_thieu")
    String gioithieu;

    @Column(name = "mo_ta")
    String mota;

    @Column(name = "macd")
    int macd;

    @Column(name = "gia_tour")
    String giatour;

    @Column(name = "ngay_tao")
    LocalDateTime ngaytao;
}
