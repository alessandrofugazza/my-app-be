package com.naru.my_app_be.playground.apitests.service;


import com.naru.my_app_be.playground.apitests.entity.ApiTest;
import com.naru.my_app_be.playground.apitests.repository.ApiTestRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiTestService {

    private final ApiTestRepo apiTestRepo;

    public List<ApiTest> getAllApiTests(){
        return apiTestRepo.findAll();
    }

    public List<ApiTest> searchApiTests(String query) {
        return apiTestRepo.findAll().stream()
                .filter(apiTest -> apiTest.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public ApiTest getApiTestById(UUID id){
        Optional<ApiTest> optionalApiTest = apiTestRepo.findById(id);
        if(optionalApiTest.isPresent()){
            return optionalApiTest.get();
        }
        log.info("ApiTest with id: {} doesn't exist", id);
        return null;
    }

    public ApiTest saveApiTest (ApiTest ApiTest){
        ApiTest.setCreatedAt(LocalDateTime.now());
        ApiTest.setUpdatedAt(LocalDateTime.now());
        ApiTest savedApiTest = apiTestRepo.save(ApiTest);

        log.info("ApiTest with id: {} saved successfully", ApiTest.getId());
        return savedApiTest;
    }

    public ApiTest updateApiTest (ApiTest ApiTest) {
        Optional<ApiTest> existingApiTest = apiTestRepo.findById(ApiTest.getId());
        ApiTest.setCreatedAt(existingApiTest.get().getCreatedAt());
        ApiTest.setUpdatedAt(LocalDateTime.now());

        ApiTest updatedApiTest = apiTestRepo.save(ApiTest);

        log.info("ApiTest with id: {} updated successfully", ApiTest.getId());
        return updatedApiTest;
    }

    public void deleteApiTestById (UUID id) {
        apiTestRepo.deleteById(id);
    }

}
