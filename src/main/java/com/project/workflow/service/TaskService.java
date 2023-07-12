package com.project.workflow.service;

import com.project.workflow.dto.custom.TaskListCreateDto;
import org.springframework.http.ResponseEntity;

public interface TaskService {
    ResponseEntity createTask(TaskListCreateDto taskListCreateDto);

    ResponseEntity getAllTasks();

}
