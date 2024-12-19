package com.websitesaoviet.WebsiteSaoViet.repository;

import com.websitesaoviet.WebsiteSaoViet.entity.Tour;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, String> {
    @Query("SELECT t FROM Tour t ORDER BY t.NgayTao DESC")
    List<Tour> findToursLatest(Pageable pageable);

    @Query("SELECT t FROM Tour t WHERE t.MaCD = :maCD")
    List<Tour> findToursByTopic(@Param("maCD")int id);
}
