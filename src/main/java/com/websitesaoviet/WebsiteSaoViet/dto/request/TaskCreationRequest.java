package com.websitesaoviet.WebsiteSaoViet.dto.request;

import java.time.LocalDate;

public class TaskCreationRequest {
    private String MaTour;
    private String MaHDV;
    private String GiaHDV;
    private LocalDate NgayKH;
    private LocalDate NgayKT;
    private String TrangThai;

    public String getMaTour() {
        return MaTour;
    }

    public void setMaTour(String maTour) {
        MaTour = maTour;
    }

    public String getMaHDV() {
        return MaHDV;
    }

    public void setMaHDV(String maHDV) {
        MaHDV = maHDV;
    }

    public String getGiaHDV() {
        return GiaHDV;
    }

    public void setGiaHDV(String giaHDV) {
        GiaHDV = giaHDV;
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

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
