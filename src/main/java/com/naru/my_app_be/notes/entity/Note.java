package com.naru.my_app_be.notes.entity;

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
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String link;
    private String source;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
