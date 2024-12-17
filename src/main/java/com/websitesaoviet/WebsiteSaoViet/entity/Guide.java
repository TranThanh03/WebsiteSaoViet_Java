package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "huongdanvien")

public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "mahdv", unique = true)
    private String MaHDV;

    @Column(name = "tenhdv")
    private String TenHDV;

    @Column(name = "anhhdv")
    private String AnhHDV;

    @Column(name = "gioi_tinh")
    private String GioiTinh;

    @Column(name = "ngay_sinh")
    private LocalDate NgaySinh;

    @Column(name = "sdt")
    private String SDT;

    @Column(name = "email")
    private String Email;

    @Column(name = "mo_ta")
    private String MoTa;

    @Column(name = "danh_gia")
    private int DanhGia;

    public String getMaHDV() {
        return MaHDV;
    }

    public void setMaHDV(String maHDV) {
        this.MaHDV = maHDV;
    }

    public String getTenHDV() {
        return TenHDV;
    }

    public void setTenHDV(String tenHDV) {
        this.TenHDV = tenHDV;
    }

    public String getAnhHDV() {
        return AnhHDV;
    }

    public void setAnhHDV(String anhHDV) {
        this.AnhHDV = anhHDV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.GioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.NgaySinh = ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        this.MoTa = moTa;
    }

    public int getDanhGia() {
        return DanhGia;
    }

    public void setDanhGia(int danhGia) {
        this.DanhGia = danhGia;
    }
}
