package com.project.workflow.service.impl;

import com.project.workflow.dao.TaskTypeDao;
import com.project.workflow.dto.TaskTypeDto;
import com.project.workflow.dto.custom.TaskTypeCreateDto;
import com.project.workflow.model.TaskType;
import com.project.workflow.service.TaskTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskTypeServiceImpl implements TaskTypeService {
    private final TaskTypeDao taskTypeDao;

    public TaskTypeServiceImpl(TaskTypeDao taskTypeDao) {
        this.taskTypeDao = taskTypeDao;
    }

    @Override
    public ResponseEntity createTaskType(TaskTypeCreateDto taskTypeCreateDto) {
        try {

            TaskType taskType = new TaskType();
            taskType.setTaskTypeName(taskTypeCreateDto.getTaskTypeName());
            taskType.setDescription(taskTypeCreateDto.getDescription());
            taskType.setIsActive(true);

            taskType = taskTypeDao.save(taskType);
            if (taskType == null) {
                throw new RuntimeException("Status type create request failed");
            } else {
                return ResponseEntity.ok(taskType.toDto());
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity getAllTaskTypes() {
        try {
            List<TaskType> taskTypeList = taskTypeDao.findAll();
            List<TaskTypeDto> taskTypeDtoList = new ArrayList<>();
            if (!taskTypeList.isEmpty()) {
                for (TaskType s : taskTypeList) {
                    taskTypeDtoList.add(s.toDto());
                }
            }
            return ResponseEntity.ok(taskTypeDtoList);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
