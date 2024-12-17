package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String MaTour;
    private String TenTour;
    private String AnhTour;
    private String GioiThieu;
    private String MoTa;
    private int MaCD;
    private String GiaTour;

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

    public String getAnhTour() {
        return AnhTour;
    }

    public void setAnhTour(String anhTour) {
        AnhTour = anhTour;
    }

    public String getGioiThieu() {
        return GioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        GioiThieu = gioiThieu;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getMaCD() {
        return MaCD;
    }

    public void setMaCD(int maCD) {
        MaCD = maCD;
    }

    public String getGiaTour() {
        return GiaTour;
    }

    public void setGiaTour(String giaTour) {
        GiaTour = giaTour;
    }
}
