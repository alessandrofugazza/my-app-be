package com.naru.my_app_be.learnsubjects.repository;

import com.naru.my_app_be.learnsubjects.entity.LearnSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LearnSubjectRepo extends JpaRepository<LearnSubject, UUID> {
}

