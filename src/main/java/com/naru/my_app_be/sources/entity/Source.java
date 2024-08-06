package com.naru.my_app_be.sources.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// CHECK WHATS EVEN THE FUCKING POINT OF THIS ANNOTATION
//@RequiredArgsConstructor
@Entity
@Table(name = "sources")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String author;
    private String type;
    private String topic;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
