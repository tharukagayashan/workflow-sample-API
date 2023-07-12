package com.project.workflow.model;

import com.project.workflow.dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TASK",indexes = {
        @Index(name = "fk_TASK_TASK_TYPE_ID_idx",columnList = "TASK_TYPE_ID")
})
public class Task {

    @Id
    @SequenceGenerator(name = "TASK", sequenceName = "TASK_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "TASK", strategy = GenerationType.SEQUENCE)
    @Column(name = "TASK_ID")
    private Integer taskId;

    @Column(name = "NAME")
    private String taskName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SEQUENCE_NO")
    private Integer seqNo;

    @Column(name = "FRONT_URL")
    private String frontUrl;

    @Column(name = "IS_COMPLETED")
    private Boolean isCompleted;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_TYPE_ID",referencedColumnName = "TASK_TYPE_ID",nullable = false)
    private TaskType taskType;

    public TaskDto toDto() {
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskId(this.getTaskId());
        taskDto.setTaskName(this.getTaskName());
        taskDto.setDescription(this.getDescription());
        taskDto.setSeqNo(this.getSeqNo());
        taskDto.setFrontUrl(this.getFrontUrl());
        taskDto.setIsCompleted(this.getIsCompleted());
        taskDto.setIsActive(this.getIsActive());
        taskDto.setTaskType(this.getTaskType().toDto());
        return taskDto;
    }
}
