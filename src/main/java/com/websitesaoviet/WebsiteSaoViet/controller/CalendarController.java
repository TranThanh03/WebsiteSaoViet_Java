package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.CalendarCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.CalendarUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Calendar;
import com.websitesaoviet.WebsiteSaoViet.service.CalendarService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/calendars")
public class CalendarController {
    CalendarService calendarService;

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
