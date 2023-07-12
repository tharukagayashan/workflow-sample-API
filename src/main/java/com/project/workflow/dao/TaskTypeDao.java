package com.project.workflow.dao;

import com.project.workflow.model.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeDao extends JpaRepository<TaskType, Integer> {
}