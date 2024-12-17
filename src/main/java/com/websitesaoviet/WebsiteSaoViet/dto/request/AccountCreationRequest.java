package com.websitesaoviet.WebsiteSaoViet.dto.request;

public class AccountCreationRequest {
    private String SDT;
    private String Email;
    private String MatKhau;
    private String Quyen;

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

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String quyen) {
        Quyen = quyen;
    }
}
