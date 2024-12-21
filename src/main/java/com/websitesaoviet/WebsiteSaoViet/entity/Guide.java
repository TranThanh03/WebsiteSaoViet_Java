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
    String mahdv;

    @Column(name = "tenhdv")
    String tenhdv;

    @Column(name = "anhhdv")
    String anhhdv;

    @Column(name = "gioi_tinh")
    String gioitinh;

    @Column(name = "ngay_sinh")
    LocalDate ngaysinh;

    @Transient
    int tuoi;

    @Column(name = "sdt")
    String sdt;

    @Column(name = "email")
    String email;

    @Column(name = "mo_ta", columnDefinition = "TEXT")
    String mota;

    @Column(name = "danh_gia")
    int danhgia;
}
