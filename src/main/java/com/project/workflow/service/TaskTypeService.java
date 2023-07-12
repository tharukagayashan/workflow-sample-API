package com.project.workflow.service;

import com.project.workflow.dto.custom.TaskTypeCreateDto;
import org.springframework.http.ResponseEntity;

public interface TaskTypeService {
    ResponseEntity createTaskType(TaskTypeCreateDto taskTypeCreateDto);

    ResponseEntity getAllTaskTypes();
}
