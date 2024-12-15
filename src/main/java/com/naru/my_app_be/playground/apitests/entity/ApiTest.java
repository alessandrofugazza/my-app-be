package com.naru.my_app_be.playground.apitests.entity;

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
@Table(name = "api_tests")
public class ApiTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String subtitle;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
