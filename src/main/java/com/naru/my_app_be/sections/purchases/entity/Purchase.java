package com.naru.my_app_be.sections.purchases.entity;

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
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    @ElementCollection
    @CollectionTable(name = "purchase_notes", joinColumns = @JoinColumn(name = "purchase_id"))
    @Column(name = "note")
    private List<String> notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
