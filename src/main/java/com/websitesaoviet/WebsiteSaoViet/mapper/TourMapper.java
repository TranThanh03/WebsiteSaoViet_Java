package com.websitesaoviet.WebsiteSaoViet.mapper;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TourCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.TourUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.TourResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Tour;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TourMapper {
    Tour createTour(TourCreationRequest request);

    TourResponse toTourResponse(Tour tour);

    List<TourResponse> toListToursResponse(List<Tour> toursList);

    void updateTour(@MappingTarget Tour tour, TourUpdateRequest request);
}
