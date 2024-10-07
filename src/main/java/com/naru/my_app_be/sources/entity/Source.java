package com.naru.my_app_be.sources.entity;

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
    private String description;
    private String source;
    private String type;
    private String topic;
    private String macroTopic;
    @ElementCollection
    @CollectionTable(name = "source_notes", joinColumns = @JoinColumn(name = "source_id"))
    @Column(name = "note")
    private List<String> notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
