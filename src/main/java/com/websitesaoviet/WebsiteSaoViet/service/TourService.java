package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TourCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TourUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Tour;
import com.websitesaoviet.WebsiteSaoViet.repository.TourRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class TourService {
    TourRepository tourRepository;

    public Tour createTour(TourCreationRequest request) {
        Tour tour = new Tour();

        tour.setTenTour(request.getTenTour());
        tour.setAnhTour(request.getAnhTour());
        tour.setGioiThieu(request.getGioiThieu());
        tour.setMoTa(request.getMoTa());
        tour.setMaCD(request.getMaCD());
        tour.setGiaTour(request.getGiaTour());

        return tourRepository.save(tour);
    }

    public List<Tour> getTours() {
        return tourRepository.findAll();
    }

    public Tour getTourById(String id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour không hợp lệ!"));
    }

    public Tour updateTour(String id, TourUpdateRequest request) {
        Tour tour = getTourById(id);

        tour.setTenTour(request.getTenTour());
        tour.setGioiThieu(request.getGioiThieu());
        tour.setMoTa(request.getMoTa());
        tour.setMaCD(request.getMaCD());
        tour.setGiaTour(request.getGiaTour());

        if(request.getAnhTour() != null && !request.getAnhTour().isEmpty()) {
            tour.setAnhTour(request.getAnhTour());
        }

        return tourRepository.save(tour);
    }

    public void deleteTour(String id) {
        tourRepository.deleteById(id);
    }

    public List<Tour> getTourLatest() {
        Pageable pageable = PageRequest.of(0, 12);

        return tourRepository.findToursLatest(pageable);
    }

    public List<Tour> getToursByTopic(int id) {
        return tourRepository.findToursByTopic(id);
    }
}
