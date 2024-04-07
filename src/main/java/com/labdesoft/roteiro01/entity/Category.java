package com.labdesoft.roteiro01.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="category"  )
public class Category {

    @Id
    @Column(name="name")
    private String name;

    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

}
