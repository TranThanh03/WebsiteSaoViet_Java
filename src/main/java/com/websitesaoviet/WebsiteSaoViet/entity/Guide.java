package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "huongdanvien")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "mahdv", unique = true)
    String MaHDV;

    @Column(name = "tenhdv")
    String TenHDV;

    @Column(name = "anhhdv")
    String AnhHDV;

    @Column(name = "gioi_tinh")
    String GioiTinh;

    @Column(name = "ngay_sinh")
    LocalDate NgaySinh;

    @Column(name = "sdt")
    String SDT;

    @Column(name = "email")
    String Email;

    @Column(name = "mo_ta")
    String MoTa;

    @Column(name = "danh_gia")
    int DanhGia;
}
