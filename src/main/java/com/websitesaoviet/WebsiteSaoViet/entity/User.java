package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "khachhang")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "makh", unique = true)
    private String MaKH;

    @Column(name = "tenkh")
    private String TenKH;

    @Column(name = "matk")
    private String MaTK;

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        this.MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        this.TenKH = tenKH;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String maTK) {
        this.MaTK = maTK;
    }
}
