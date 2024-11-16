package com.naru.my_app_be.sections.progresses.repository;

import com.naru.my_app_be.sections.progresses.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProgressRepo extends JpaRepository<Progress, UUID> {
}

