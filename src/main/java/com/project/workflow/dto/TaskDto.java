package com.project.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private Integer taskId;
    private String taskName;
    private String description;
    private Integer seqNo;
    private String frontUrl;
    private Boolean isCompleted;
    private Boolean isActive;

    private TaskTypeDto taskType;
}
