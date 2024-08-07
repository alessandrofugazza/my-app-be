package com.naru.my_app_be.progresses.entity;

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
@Table(name = "progresses")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String source;
    private String progress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
