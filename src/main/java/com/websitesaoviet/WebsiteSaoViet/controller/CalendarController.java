package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.CalendarCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.CalendarUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TaskTourGuideRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Calendar;
import com.websitesaoviet.WebsiteSaoViet.service.CalendarService;
import com.websitesaoviet.WebsiteSaoViet.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/calendars")
public class CalendarController {
    CalendarService calendarService;
    TaskService taskService;

    @PostMapping()
    Calendar createCalendar(@RequestBody CalendarCreationRequest request) {
        return calendarService.createCalendar(request);
    }

    @GetMapping()
    List<Calendar> getCalendars() {
        return calendarService.getCalendars();
    }

    @GetMapping("/booking/{id}")
    public String showCalendarInfor(@PathVariable int id, HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        TaskTourGuideRequest task = taskService.findTaskById(id);
        model.addAttribute("task", task);

        return "client/calendar/infor";
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
