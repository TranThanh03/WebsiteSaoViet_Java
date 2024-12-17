package com.websitesaoviet.WebsiteSaoViet.dto.request;

import java.time.LocalDate;

public class GuideCreationRequest {
    private String TenHDV;
    private String AnhHDV;
    private String GioiTinh;
    private LocalDate NgaySinh;
    private String SDT;
    private String Email;
    private String MoTa;
    private int DanhGia;

    public String getTenHDV() {
        return TenHDV;
    }

    public void setTenHDV(String tenHDV) {
        TenHDV = tenHDV;
    }

    public String getAnhHDV() {
        return AnhHDV;
    }

    public void setAnhHDV(String anhHDV) {
        AnhHDV = anhHDV;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        NgaySinh = ngaySinh;
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
        Email = email;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getDanhGia() {
        return DanhGia;
    }

    public void setDanhGia(int danhGia) {
        DanhGia = danhGia;
    }
}
