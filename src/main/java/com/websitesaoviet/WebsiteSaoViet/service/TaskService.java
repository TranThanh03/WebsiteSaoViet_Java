package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TaskCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TaskUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Task;
import com.websitesaoviet.WebsiteSaoViet.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskCreationRequest request) {
        Task task = new Task();

        task.setMaTour(request.getMaTour());
        task.setMaHDV(request.getMaHDV());
        task.setGiaHDV(request.getGiaHDV());
        task.setNgayKH(request.getNgayKH());
        task.setNgayKT(request.getNgayKT());

        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lịch phân công không hợp lệ!"));
    }

    public Task updateTask(String id, TaskUpdateRequest request) {
        Task task = getTaskById(id);

        task.setTrangThai(request.getTrangThai());

        return taskRepository.save(task);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
}
