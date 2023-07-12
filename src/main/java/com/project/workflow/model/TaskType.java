package com.project.workflow.model;

import com.project.workflow.dto.TaskTypeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TASK_TYPE")
public class TaskType {

    @Id
    @SequenceGenerator(name = "TASK_TYPE", sequenceName = "TASK_TYPE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "TASK_TYPE", strategy = GenerationType.SEQUENCE)
    @Column(name = "TASK_TYPE_ID")
    private Integer taskTypeId;

    @Column(name = "NAME")
    private String taskTypeName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    public TaskTypeDto toDto() {
        TaskTypeDto taskTypeDto = new TaskTypeDto();
        taskTypeDto.setTaskTypeId(this.getTaskTypeId());
        taskTypeDto.setTaskTypeName(this.getTaskTypeName());
        taskTypeDto.setDescription(this.getDescription());
        taskTypeDto.setIsActive(this.getIsActive());
        return taskTypeDto;
    }

}