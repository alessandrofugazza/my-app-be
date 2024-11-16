package com.naru.my_app_be.sections.projects.repository;

import com.naru.my_app_be.sections.projects.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepo extends JpaRepository<Project, UUID> {
}

