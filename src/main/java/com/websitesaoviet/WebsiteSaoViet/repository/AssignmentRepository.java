package com.websitesaoviet.WebsiteSaoViet.repository;

import com.websitesaoviet.WebsiteSaoViet.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, String> {
    @Query("SELECT MAX(a.id) FROM Assignment a")
    String findMaxId();

    Optional<Assignment> findAssignmentByGuideId(String guideId);

    @Query("SELECT COUNT(a) > 0 " +
            "FROM Assignment a WHERE a.guideId = :guideId AND " +
            "(a.startDate BETWEEN :startDate AND :endDate OR " +
            "a.endDate BETWEEN :startDate AND :endDate OR " +
            "(a.startDate <= :startDate AND a.endDate >= :endDate))")
    boolean existsAssignmentByGuideId(@Param("guideId") String guideId,
                                      @Param("startDate") LocalDate startDate,
                                      @Param("endDate") LocalDate endDate);
}