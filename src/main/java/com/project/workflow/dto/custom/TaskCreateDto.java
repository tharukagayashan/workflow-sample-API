package com.project.workflow.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskCreateDto {
    private String taskName;
    private String description;
    private String frontUrl;
}
