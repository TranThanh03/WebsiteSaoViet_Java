package com.websitesaoviet.WebsiteSaoViet.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(4444, "Uncategorized error!"),
    PHONENUMBER_EXISTED(1001, "Số điện thoại đã tồn tại!"),
    EMAIL_EXISTED(1002, "Email đã tồn tại!"),
    PASSWORD_INVALID(1003, "Mật khẩu có độ dài từ 8 ký tự trở lên!"),
    PHONENUMBER_INVALID(1004, "Số điện thoại phải có đúng 10 chữ số!"),
    NOT_NULL_LOGIN(1005, "Vui lòng nhập thông tin để đăng nhập!"),
    ACCOUNT_NOT_EXITED(1006, "Tài khoản không tồn tại!")
    ;
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code = 1000;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
