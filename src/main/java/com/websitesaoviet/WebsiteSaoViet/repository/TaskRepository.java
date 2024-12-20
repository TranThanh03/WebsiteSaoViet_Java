package com.websitesaoviet.WebsiteSaoViet.repository;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TaskTourGuideRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    @Query("SELECT new com.websitesaoviet.WebsiteSaoViet.dto.request.TaskTourGuideRequest(t, tour, g)" +
            "FROM Task t " +
            "INNER JOIN Tour tour ON t.matour = tour.matour " +
            "INNER JOIN Guide g ON t.mahdv = g.mahdv " +
            "WHERE t.matour = :id")
    List<TaskTourGuideRequest> findGuidesByTourId(@Param("id") String id);

    @Query("SELECT new com.websitesaoviet.WebsiteSaoViet.dto.request.TaskTourGuideRequest(t, tour, g)" +
            "FROM Task t " +
            "INNER JOIN Tour tour ON t.matour = tour.matour " +
            "INNER JOIN Guide g ON t.mahdv = g.mahdv " +
            "WHERE t.mahdv = :id")
    List<TaskTourGuideRequest> findToursByGuideId(@Param("id")String id);

    @Query("SELECT new com.websitesaoviet.WebsiteSaoViet.dto.request.TaskTourGuideRequest(t, tour, g)" +
            "FROM Task t " +
            "INNER JOIN Tour tour ON t.matour = tour.matour " +
            "INNER JOIN Guide g ON t.mahdv = g.mahdv " +
            "WHERE t.mapc = :id")
    TaskTourGuideRequest findTaskById(@Param("id")int id);
}