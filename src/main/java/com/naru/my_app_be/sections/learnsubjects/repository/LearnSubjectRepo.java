package com.naru.my_app_be.sections.learnsubjects.repository;

import com.naru.my_app_be.sections.learnsubjects.entity.LearnSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LearnSubjectRepo extends JpaRepository<LearnSubject, UUID> {
}

