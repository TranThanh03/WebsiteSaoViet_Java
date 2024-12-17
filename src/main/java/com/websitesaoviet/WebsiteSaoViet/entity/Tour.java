package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tour")

public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ma_tour", unique = true)
    private String MaTour;

    @Column(name = "ten_tour")
    private String TenTour;

    @Column(name = "anh_tour")
    private String AnhTour;

    @Column(name = "gioi_thieu")
    private String GioiThieu;

    @Column(name = "mo_ta")
    private String MoTa;

    @Column(name = "macd")
    private int MaCD;

    @Column(name = "gia_tour")
    private String GiaTour;

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

    public String getAnhTour() {
        return AnhTour;
    }

    public void setAnhTour(String anhTour) {
        this.AnhTour = anhTour;
    }

    public String getGioiThieu() {
        return GioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.GioiThieu = gioiThieu;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        this.MoTa = moTa;
    }

    public int getMaCD() {
        return MaCD;
    }

    public void setMaCD(int maCD) {
        this.MaCD = maCD;
    }

    public String getGiaTour() {
        return GiaTour;
    }

    public void setGiaTour(String giaTour) {
        this.GiaTour = giaTour;
    }
}
