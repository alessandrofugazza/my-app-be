package com.naru.my_app_be.sources.entity;

import com.naru.my_app_be.sources.enums.ESourceTopic;
import com.naru.my_app_be.sources.enums.ESourceType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@RequiredArgsConstructor
@Entity
@Table(name = "sources")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private ESourceType type;
    @Enumerated(EnumType.STRING)
    private ESourceTopic topic;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
