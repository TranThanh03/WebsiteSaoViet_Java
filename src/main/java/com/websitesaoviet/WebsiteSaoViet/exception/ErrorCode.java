package com.websitesaoviet.WebsiteSaoViet.exception;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(4444, "Uncategorized error!"),
    PHONENUMBER_EXISTED(1001, "Số điện thoại đã tồn tại!"),
    EMAIL_EXISTED(1002, "Email đã tồn tại!"),
    PASSWORD_INVALID(1003, "Mật khẩu có độ dài từ 8 ký tự trở lên!"),
    PHONENUMBER_INVALID(1004, "Số điện thoại phải có đúng 10 chữ số!"),
    EMAIL_INVALID(1005, "Email phải đúng định dạng 'example@example.com'!"),
    NOT_NULL_LOGIN(1006, "Vui lòng nhập thông tin để đăng nhập!"),
    USER_NOT_EXITED(1007, "Khách hàng không tồn tại!"),
    TOUR_NOT_EXITED(1008, "Tour không tồn tại!"),
    PEOPLE_INVALID(1009, "Số lượng người phải lớn hơn 0!"),
    ASSIGNMENT_NOT_EXITED(1010, "Lịch phân công không tồn tại!"),
    GUIDE_ASSIGNED(1011, "Hướng dẫn viên này bị trùng lịch phân công!"),
    STARTDATE_NOT_NULL(1012, "Ngày khởi hành không được bỏ trống!"),
    ENDDATE_NOT_NULL(1013, "Ngày kết thúc không được bỏ trống!"),
    STARTDATE_INVALID(1014, "Ngày khởi hành không được trước ngày " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "!"),
    ENDDATE_INVALID(1015, "Ngày kết thúc không được trước ngày khởi hành!")
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
