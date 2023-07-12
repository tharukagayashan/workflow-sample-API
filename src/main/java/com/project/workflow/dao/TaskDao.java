package com.project.workflow.dao;

import com.project.workflow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Integer> {
}