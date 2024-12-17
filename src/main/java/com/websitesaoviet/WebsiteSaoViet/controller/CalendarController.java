package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.CalendarCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.CalendarUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Calendar;
import com.websitesaoviet.WebsiteSaoViet.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendars")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    @PostMapping()
    Calendar createCalendar(@RequestBody CalendarCreationRequest request) {
        return calendarService.createCalendar(request);
    }

    @GetMapping()
    List<Calendar> getCalendars() {
        return calendarService.getCalendars();
    }

    @GetMapping("/{id}")
    Calendar getCalendarById(@PathVariable String id) {
        return calendarService.getCalendarById(id);
    }

    @PutMapping("/{id}")
    Calendar updateCalendar(@PathVariable String id, @RequestBody CalendarUpdateRequest request) {
        return calendarService.updateCalendar(id, request);
    }
}
