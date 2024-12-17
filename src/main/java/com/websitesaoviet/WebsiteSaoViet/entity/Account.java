package com.websitesaoviet.WebsiteSaoViet.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "taikhoan")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "matk", unique = true)
    private String MaTK;

    @Column(name = "sdt", unique = true)
    private String sdt;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "mat_khau", unique = true)
    private String MatKhau;

    @Column(name = "quyen", unique = true)
    private String Quyen;

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String maTK) {
        MaTK = maTK;
    }

    public String getSDT() {
        return sdt;
    }

    public void setSDT(String SDT) {
        this.sdt = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        this.MatKhau = matKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String quyen) {
        this.Quyen = quyen;
    }
}
