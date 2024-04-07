package com.labdesoft.roteiro01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.labdesoft.roteiro01.entity.Task;
import com.labdesoft.roteiro01.entity.TaskStatus;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findById(Long id);

    List<Task> findByStatus(TaskStatus status);

    @Query(value = "SELECT * FROM task t WHERE t.label_name IN (SELECT name FROM label l WHERE l.name = :name)", nativeQuery = true)
    List<Task> findByLabel_Name(String name);
    
    List<Task> findByCategoryName(String categoryName);
    
}