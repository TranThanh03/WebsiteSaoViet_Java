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
    int madd;

    @Column(name = "makh")
    String makh;

    @Column(name = "tenkh")
    String tenkh;

    @Column(name = "ma_tour")
    String matour;

    @Column(name = "ten_tour")
    String tentour;

    @Column(name = "mahdv")
    String mahdv;

    @Column(name = "tenhdv")
    String tenhdv;

    @Column(name = "mapc")
    String mapc;

    @Column(name = "ngaykh")
    LocalDate ngaykh;

    @Column(name = "ngaykt")
    LocalDate ngaykt;

    @Column(name = "gia_tour")
    String giatour;

    @Column(name = "giahdv")
    String giahdv;

    @Column(name = "tong_tien")
    String tongtien;

    @Column(name = "thoi_gian_dat")
    LocalDateTime thoigiandat;

    @Column(name = "trang_thai")
    String trangthai;
}
