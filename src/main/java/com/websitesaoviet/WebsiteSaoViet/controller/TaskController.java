package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TaskCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TaskTourGuideRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TaskUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Task;
import com.websitesaoviet.WebsiteSaoViet.service.TaskService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskController {
    TaskService taskService;

    @PostMapping()
    Task createTask(@RequestBody TaskCreationRequest request) {
        return taskService.createTask(request);
    }

    @GetMapping("/list/{id}")
    public String getGuidesByTourId(@PathVariable String id, HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());

        List<TaskTourGuideRequest> tasks = taskService.findGuidesByTourId(id);

        tasks.forEach(task -> {
            LocalDate birthDate = task.getGuide().getNgaysinh();
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            task.getGuide().setTuoi(age);
        });

        model.addAttribute("tasks", tasks);

        return "client/guide/list";
    }

    @GetMapping()
    List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    Task getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    Task updateTask(@PathVariable int id, @RequestBody TaskUpdateRequest request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        String message = String.format("Xóa lịch phân công thành công.");
        return ResponseEntity.ok(message);
    }
}
