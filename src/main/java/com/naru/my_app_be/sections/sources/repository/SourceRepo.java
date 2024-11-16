package com.naru.my_app_be.sections.sources.repository;

import com.naru.my_app_be.sections.sources.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SourceRepo extends JpaRepository<Source, UUID> {
}

