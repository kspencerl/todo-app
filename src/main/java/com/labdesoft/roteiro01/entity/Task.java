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

    @Column(name="priority", updatable = true)
    private Integer priority;

    @ManyToOne
    @JoinColumn(name="label_name")
    private Label label;
    
    @ManyToOne
    @JoinColumn(name="category_name")
    private Category category;

    @Column(name="due_date", updatable = true)
    private LocalDateTime dueDate;

    @Column(name="status", updatable = true)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;
    
}
