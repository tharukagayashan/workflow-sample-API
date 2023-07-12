package com.project.workflow.rest;

import com.project.workflow.dto.TaskTypeDto;
import com.project.workflow.dto.custom.TaskTypeCreateDto;
import com.project.workflow.service.TaskTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-type")
public class TaskTypeController {

    private final TaskTypeService taskTypeService;

    public TaskTypeController(TaskTypeService taskTypeService) {
        this.taskTypeService = taskTypeService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskTypeDto> createTaskType(@RequestBody TaskTypeCreateDto taskTypeCreateDto){
        ResponseEntity response = taskTypeService.createTaskType(taskTypeCreateDto);
        return response;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<TaskTypeDto>> getAllTaskTypes(){
        ResponseEntity response = taskTypeService.getAllTaskTypes();
        return response;
    }

}
