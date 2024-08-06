package com.naru.my_app_be.sources.repository;

import com.naru.my_app_be.sources.entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SourceRepo extends JpaRepository<Source, UUID> {
}

