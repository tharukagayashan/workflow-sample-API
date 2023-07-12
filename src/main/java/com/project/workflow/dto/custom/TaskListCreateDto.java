package com.project.workflow.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskListCreateDto {
    private Integer taskTypeId;
    private List<TaskCreateDto> taskList;
}