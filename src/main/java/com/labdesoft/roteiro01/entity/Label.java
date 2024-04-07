package com.labdesoft.roteiro01.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="label")
public class Label {

    @Id
    @Column(name="name")
    private String name;

    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "label")
    private List<Task> tasks;
        
}
