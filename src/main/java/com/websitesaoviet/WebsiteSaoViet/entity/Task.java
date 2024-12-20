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
    int mapc;

    @Column(name = "ma_tour")
    String matour;

    @Column(name = "mahdv")
    String mahdv;

    @Column(name = "giahdv")
    String giahdv;

    @Column(name = "ngaykh")
    LocalDate ngaykh;

    @Column(name = "ngaykt")
    LocalDate ngaykt;

    @Column(name = "trang_thai")
    String trangthai;
}
