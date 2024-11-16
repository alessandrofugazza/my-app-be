package com.naru.my_app_be.sections.projects.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    @ElementCollection
    @CollectionTable(name = "project_todos", joinColumns = @JoinColumn(name = "project_id"))
    @OrderColumn(name = "todo_order")
    @Column(name = "todo")
    private List<String> todos;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
