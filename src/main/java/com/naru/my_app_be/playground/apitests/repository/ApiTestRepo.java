package com.naru.my_app_be.playground.apitests.repository;

import com.naru.my_app_be.playground.apitests.entity.ApiTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApiTestRepo extends JpaRepository<ApiTest, UUID> {
}

