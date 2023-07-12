package com.project.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskTypeDto {
    private Integer taskTypeId;
    private String taskTypeName;
    private String description;
    private Boolean isActive;
}
