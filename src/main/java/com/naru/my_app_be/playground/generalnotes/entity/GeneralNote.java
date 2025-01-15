package com.naru.my_app_be.playground.generalnotes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "general_notes")
public class GeneralNote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    @Lob
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}