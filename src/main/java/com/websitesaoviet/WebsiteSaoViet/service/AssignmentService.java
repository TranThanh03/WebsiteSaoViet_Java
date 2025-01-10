package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AssignmentCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.AssignmentResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Assignment;
import com.websitesaoviet.WebsiteSaoViet.exception.AppException;
import com.websitesaoviet.WebsiteSaoViet.exception.ErrorCode;
import com.websitesaoviet.WebsiteSaoViet.mapper.AssignmentMapper;
import com.websitesaoviet.WebsiteSaoViet.repository.AssignmentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AssignmentService {
    AssignmentRepository assignmentRepository;
    AssignmentMapper assignmentMapper;

    public AssignmentResponse createAssignment(AssignmentCreationRequest request) {
        LocalDate today = LocalDate.now();

        if (request.getStartDate().isBefore(today)) {
            throw new AppException(ErrorCode.STARTDATE_INVALID);
        }
        if (request.getEndDate().isBefore(request.getStartDate())) {
            throw new AppException(ErrorCode.ENDDATE_INVALID);
        }

        if(assignmentRepository.existsAssignmentByGuideId(request.getGuideId(), request.getStartDate(), request.getEndDate())) {
            throw new AppException(ErrorCode.GUIDE_ASSIGNED);
        }

        Assignment assignment = assignmentMapper.createAssignment(request);

        assignment.setId(String.valueOf(generateNextId()));
        assignment.setStatus("Đang diễn ra");

        return assignmentMapper.toAssignmentResponse(assignmentRepository.save(assignment));
    }

    public List<AssignmentResponse> getAssignments() {
        return assignmentMapper.toListAssignmentsResponse(assignmentRepository.findAll());
    }

    public void deleteAssignment(String id) {
        if (!assignmentRepository.existsById(id)) {
            throw new AppException(ErrorCode.ASSIGNMENT_NOT_EXITED);
        }

        assignmentRepository.deleteById(id);
    }

    public String generateNextId() {
        String maxId = assignmentRepository.findMaxId();
        if (maxId == null) {
            return "PC25000001";
        }

        int currentMax = Integer.parseInt(maxId.substring(2));
        int nextId = currentMax + 1;
        return "PC" + nextId;
    }
}