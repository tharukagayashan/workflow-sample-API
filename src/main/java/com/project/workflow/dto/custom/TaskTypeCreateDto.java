package com.project.workflow.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskTypeCreateDto {
    private String taskTypeName;
    private String description;
}
