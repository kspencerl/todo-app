package com.labdesoft.roteiro01.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="name", updatable = true)
    private String name;

    @Column(name="status", updatable = true)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name="due_date", updatable = true, nullable = true)
    private LocalDateTime dueDate;

    @Column(name="type", updatable = true)
    @Enumerated(EnumType.STRING)
    private TaskType type;

    @Column(name="priority", updatable = true)
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;
}
