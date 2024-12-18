package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dondat")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "madd", unique = true)
    int MaDD;

    @Column(name = "makh")
    String MaKH;

    @Column(name = "tenkh")
    String TenKH;

    @Column(name = "ma_tour")
    String MaTour;

    @Column(name = "ten_tour")
    String TenTour;

    @Column(name = "mahdv")
    String MaHDV;

    @Column(name = "tenhdv")
    String TenHDV;

    @Column(name = "mapc")
    String MaPC;

    @Column(name = "ngaykh")
    LocalDate NgayKH;

    @Column(name = "ngaykt")
    LocalDate NgayKT;

    @Column(name = "gia_tour")
    String GiaTour;

    @Column(name = "giahdv")
    String GiaHDV;

    @Column(name = "tong_tien")
    String TongTien;

    @Column(name = "thoi_gian_dat")
    LocalDateTime ThoiGianDat;

    @Column(name = "trang_thai")
    String TrangThai;
}
