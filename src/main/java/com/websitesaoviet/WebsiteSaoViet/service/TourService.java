package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TourCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TourUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.TourResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Tour;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.mapper.TourMapper;
import com.websitesaoviet.WebsiteSaoViet.repository.TourRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TourService {
    TourRepository tourRepository;
    TourMapper tourMapper;

    public TourResponse createTour(TourCreationRequest request) {
        Tour tour = tourMapper.createTour(request);

        tour.setId(String.valueOf(generateNextId()));

        return tourMapper.toTourResponse(tourRepository.save(tour));
    }

    public List<TourResponse> getTours() {
        return tourMapper.toListToursResponse(tourRepository.findAll());
    }

    public TourResponse getTourById(String id) {
        return  tourMapper.toTourResponse(tourRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TOUR_NOT_EXITED)));
    }

    public TourResponse updateTour(String id, TourUpdateRequest request) {
        Tour tour = tourRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TOUR_NOT_EXITED));

        if (tour == null) {
            throw new AppException(ErrorCode.TOUR_NOT_EXITED);
        }

        tourMapper.updateTour(tour, request);

        return tourMapper.toTourResponse(tourRepository.save(tour));
    }

    public void deleteTour(String id) {
        if (!tourRepository.existsById(id)) {
            throw new AppException(ErrorCode.TOUR_NOT_EXITED);
        }

        tourRepository.deleteById(id);
    }

    public String generateNextId() {
        String maxId = tourRepository.findMaxId();
        if (maxId == null) {
            return "T25001";
        }

        int currentMax = Integer.parseInt(maxId.substring(1));
        int nextId = currentMax + 1;
        return "T" + nextId;
    }
}