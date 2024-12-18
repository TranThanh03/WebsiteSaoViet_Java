package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.CalendarCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.CalendarUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Calendar;
import com.websitesaoviet.WebsiteSaoViet.repository.CalendarRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CalendarService {
    CalendarRepository calendarRepository;

    public Calendar createCalendar(CalendarCreationRequest request) {
        Calendar calendar = new Calendar();
        LocalDateTime currentTime = LocalDateTime.now();

        calendar.setMaKH(request.getMaKH());
        calendar.setTenKH(request.getTenKH());
        calendar.setMaTour(request.getMaTour());
        calendar.setTenTour(request.getTenTour());
        calendar.setMaHDV(request.getMaHDV());
        calendar.setTenHDV(request.getTenHDV());
        calendar.setMaPC(request.getMaPC());
        calendar.setNgayKH(request.getNgayKH());
        calendar.setNgayKT(request.getNgayKT());
        calendar.setGiaTour(request.getGiaTour());
        calendar.setGiaHDV(request.getGiaHDV());
        calendar.setTongTien(request.getTongTien());
        calendar.setThoiGianDat(currentTime);
        calendar.setTrangThai("Đang xử lý");

        return calendarRepository.save(calendar);
    }

    public List<Calendar> getCalendars() {
        return calendarRepository.findAll();
    }

    public Calendar getCalendarById(String id) {
        return calendarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Đơn đặt không hợp lệ!"));
    }

    public Calendar updateCalendar(String id, CalendarUpdateRequest request) {
        Calendar calendar = getCalendarById(id);

        calendar.setTrangThai(request.getTrangThai());

        return calendarRepository.save(calendar);
    }
}
