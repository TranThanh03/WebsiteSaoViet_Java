package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "phancong")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapc", unique = true)
    private int MaPC;

    @Column(name = "ma_tour")
    private String MaTour;

    @Column(name = "mahdv")
    private String MaHDV;

    @Column(name = "giahdv")
    private String GiaHDV;

    @Column(name = "ngaykh")
    private LocalDate NgayKH;

    @Column(name = "ngaykt")
    private LocalDate NgayKT;

    @Column(name = "trang_thai")
    private String TrangThai;

    public int getMaPC() {
        return MaPC;
    }

    public void setMaPC(int maPC) {
        this.MaPC = maPC;
    }

    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String maTour) {
        this.MaTour = maTour;
    }

    public String getMaHDV() {
        return MaHDV;
    }

    public void setMaHDV(String maHDV) {
        this.MaHDV = maHDV;
    }

    public String getGiaHDV() {
        return GiaHDV;
    }

    public void setGiaHDV(String giaHDV) {
        this.GiaHDV = giaHDV;
    }

    public LocalDate getNgayKH() {
        return NgayKH;
    }

    public void setNgayKH(LocalDate ngayKH) {
        this.NgayKH = ngayKH;
    }

    public LocalDate getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
        this.NgayKT = ngayKT;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        this.TrangThai = trangThai;
    }
}
