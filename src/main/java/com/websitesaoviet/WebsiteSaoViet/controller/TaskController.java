package com.websitesaoviet.WebsiteSaoViet.controller;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TaskCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TaskUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Task;
import com.websitesaoviet.WebsiteSaoViet.service.TaskService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskController {
    TaskService taskService;

    @PostMapping()
    Task createTask(@RequestBody TaskCreationRequest request) {
        return taskService.createTask(request);
    }

    @GetMapping()
    List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    Task getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    Task updateTask(@PathVariable String id, @RequestBody TaskUpdateRequest request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTask(@PathVariable String id) {
        taskService.deleteTask(id);
        String message = String.format("Xóa lịch phân công thành công.");
        return ResponseEntity.ok(message);
    }
}
