package com.websitesaoviet.WebsiteSaoViet.dto.request;

public class UserCreationRequest {
    private String TenKH;
    private String MaTK;

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        TenKH = tenKH;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String maTK) {
        MaTK = maTK;
    }
}
