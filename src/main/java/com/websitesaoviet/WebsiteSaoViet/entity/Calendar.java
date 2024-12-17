package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaDD;
    private String MaKH;
    private String TenKH;
    private String MaTour;
    private String TenTour;
    private String MaHDV;
    private String TenHDV;
    private String MaPC;
    private LocalDate NgayKH;
    private LocalDate NgayKT;
    private String GiaTour;
    private String GiaHDV;
    private String TongTien;
    private LocalDateTime ThoiGianDat;
    private String TrangThai;

    public int getMaDD() {
        return MaDD;
    }

    public void setMaDD(int maDD) {
        MaDD = maDD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String maTour) {
        MaTour = maTour;
    }

    public String getTenTour() {
        return TenTour;
    }

    public void setTenTour(String tenTour) {
        TenTour = tenTour;
    }

    public String getMaHDV() {
        return MaHDV;
    }

    public void setMaHDV(String maHDV) {
        MaHDV = maHDV;
    }

    public String getTenHDV() {
        return TenHDV;
    }

    public void setTenHDV(String tenHDV) {
        TenHDV = tenHDV;
    }

    public String getMaPC() {
        return MaPC;
    }

    public void setMaPC(String maPC) {
        MaPC = maPC;
    }

    public LocalDate getNgayKH() {
        return NgayKH;
    }

    public void setNgayKH(LocalDate ngayKH) {
        NgayKH = ngayKH;
    }

    public LocalDate getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
        NgayKT = ngayKT;
    }

    public String getGiaTour() {
        return GiaTour;
    }

    public void setGiaTour(String giaTour) {
        GiaTour = giaTour;
    }

    public String getGiaHDV() {
        return GiaHDV;
    }

    public void setGiaHDV(String giaHDV) {
        GiaHDV = giaHDV;
    }

    public String getTongTien() {
        return TongTien;
    }

    public void setTongTien(String tongTien) {
        TongTien = tongTien;
    }

    public LocalDateTime getThoiGianDat() {
        return ThoiGianDat;
    }

    public void setThoiGianDat(LocalDateTime thoiGianDat) {
        ThoiGianDat = thoiGianDat;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
