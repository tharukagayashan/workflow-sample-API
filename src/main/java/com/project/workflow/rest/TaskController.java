package com.project.workflow.rest;

import com.project.workflow.dto.TaskDto;
import com.project.workflow.dto.custom.TaskListCreateDto;
import com.project.workflow.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<List<TaskDto>> createTask(@RequestBody TaskListCreateDto taskListCreateDto){
        ResponseEntity response = taskService.createTask(taskListCreateDto);
        return response;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        ResponseEntity response = taskService.getAllTasks();
        return response;
    }

}
