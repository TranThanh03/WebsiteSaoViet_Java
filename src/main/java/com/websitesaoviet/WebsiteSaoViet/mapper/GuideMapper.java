package com.websitesaoviet.WebsiteSaoViet.mapper;

import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.GuideResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Guide;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GuideMapper {
    Guide createGuide(GuideCreationRequest request);

    GuideResponse toGuideResponse(Guide guide);

    List<GuideResponse> toListGuidesResponse(List<Guide> guidesList);

    void updateGuide(@MappingTarget Guide guide, GuideUpdateRequest request);
}
