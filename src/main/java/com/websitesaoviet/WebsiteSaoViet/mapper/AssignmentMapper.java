package com.websitesaoviet.WebsiteSaoViet.mapper;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AssignmentCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.AssignmentResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Assignment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    Assignment createAssignment(AssignmentCreationRequest request);

    AssignmentResponse toAssignmentResponse(Assignment assignment);

    List<AssignmentResponse> toListAssignmentsResponse(List<Assignment> assignmentsList);
}
