package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "phancong")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapc", unique = true)
    int MaPC;

    @Column(name = "ma_tour")
    String MaTour;

    @Column(name = "mahdv")
    String MaHDV;

    @Column(name = "giahdv")
    String GiaHDV;

    @Column(name = "ngaykh")
    LocalDate NgayKH;

    @Column(name = "ngaykt")
    LocalDate NgayKT;

    @Column(name = "trang_thai")
    String TrangThai;
}
