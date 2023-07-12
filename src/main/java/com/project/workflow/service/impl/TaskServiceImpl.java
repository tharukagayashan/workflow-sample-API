package com.project.workflow.service.impl;

import com.project.workflow.dao.TaskDao;
import com.project.workflow.dao.TaskTypeDao;
import com.project.workflow.dto.TaskDto;
import com.project.workflow.dto.TaskTypeDto;
import com.project.workflow.dto.custom.TaskCreateDto;
import com.project.workflow.dto.custom.TaskListCreateDto;
import com.project.workflow.model.Task;
import com.project.workflow.model.TaskType;
import com.project.workflow.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;
    private final TaskTypeDao taskTypeDao;

    public TaskServiceImpl(TaskDao taskDao,
                           TaskTypeDao taskTypeDao) {
        this.taskDao = taskDao;
        this.taskTypeDao = taskTypeDao;
    }

    @Override
    public ResponseEntity createTask(TaskListCreateDto taskListCreateDto) {
        try {
            Integer taskTypeId = taskListCreateDto.getTaskTypeId();
            TaskType taskType = null;
            if (taskTypeId == null) {
                throw new Exception("taskTypeId null");
            } else {
                Optional<TaskType> optTaskType = taskTypeDao.findById(taskTypeId);
                if (!optTaskType.isPresent()) {
                    throw new Exception("Task type not found");
                } else {
                    taskType = optTaskType.get();
                }
            }

            List<TaskCreateDto> taskCreateDtoList = taskListCreateDto.getTaskList();
            if (taskCreateDtoList.isEmpty()) {
                throw new Exception("Task list empty");
            } else {
                List<Task> taskList = new ArrayList<>();
                Integer seqNo = 0;
                for (TaskCreateDto t : taskCreateDtoList) {
                    seqNo = seqNo + 1;
                    Task task = new Task();
                    task.setTaskName(t.getTaskName());
                    task.setDescription(t.getDescription());
                    task.setSeqNo(seqNo);
                    task.setFrontUrl(t.getFrontUrl());
                    task.setIsCompleted(false);
                    task.setTaskType(taskType);
                    task.setIsActive(true);
                    taskList.add(task);
                }
                List<TaskDto> taskDtoList = new ArrayList<>();
                taskList = taskDao.saveAll(taskList);
                for (Task t : taskList) {
                    if (t.getTaskId() == null) {
                        throw new Exception("Task create request failed");
                    } else {
                        taskDtoList.add(t.toDto());
                    }
                }
                return ResponseEntity.ok(taskDtoList);
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity getAllTasks() {

        try {
            List<Task> taskList = taskDao.findAll();
            List<TaskDto> taskDtoList = new ArrayList<>();
            if (!taskList.isEmpty()) {
                for (Task s : taskList) {
                    taskDtoList.add(s.toDto());
                }
            }
            return ResponseEntity.ok(taskDtoList);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
