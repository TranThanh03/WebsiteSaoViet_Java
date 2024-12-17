package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dondat")

public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "madd", unique = true)
    private int MaDD;

    @Column(name = "makh")
    private String MaKH;

    @Column(name = "tenkh")
    private String TenKH;

    @Column(name = "ma_tour")
    private String MaTour;

    @Column(name = "ten_tour")
    private String TenTour;

    @Column(name = "mahdv")
    private String MaHDV;

    @Column(name = "tenhdv")
    private String TenHDV;

    @Column(name = "mapc")
    private String MaPC;

    @Column(name = "ngaykh")
    private LocalDate NgayKH;

    @Column(name = "ngaykt")
    private LocalDate NgayKT;

    @Column(name = "gia_tour")
    private String GiaTour;

    @Column(name = "giahdv")
    private String GiaHDV;

    @Column(name = "tong_tien")
    private String TongTien;

    @Column(name = "thoi_gian_dat")
    private LocalDateTime ThoiGianDat;

    @Column(name = "trang_thai")
    private String TrangThai;

    public int getMaDD() {
        return MaDD;
    }

    public void setMaDD(int maDD) {
        this.MaDD = maDD;
    }

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

    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String maTour) {
        this.MaTour = maTour;
    }

    public String getTenTour() {
        return TenTour;
    }

    public void setTenTour(String tenTour) {
        this.TenTour = tenTour;
    }

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

    public String getMaPC() {
        return MaPC;
    }

    public void setMaPC(String maPC) {
        this.MaPC = maPC;
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

    public String getGiaTour() {
        return GiaTour;
    }

    public void setGiaTour(String giaTour) {
        this.GiaTour = giaTour;
    }

    public String getGiaHDV() {
        return GiaHDV;
    }

    public void setGiaHDV(String giaHDV) {
        this.GiaHDV = giaHDV;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String tongTien) {
        this.TongTien = tongTien;
    }

    public LocalDateTime getThoiGianDat() {
        return ThoiGianDat;
    }

    public void setThoiGianDat(LocalDateTime thoiGianDat) {
        this.ThoiGianDat = thoiGianDat;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        this.TrangThai = trangThai;
    }
}
