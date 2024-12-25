package com.naru.my_app_be.playground.apitests.controller;

import com.naru.my_app_be.playground.apitests.entity.ApiTest;
import com.naru.my_app_be.playground.apitests.service.ApiTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api-tests/v1")
@RequiredArgsConstructor
@Validated
public class ApiTestController {

    private final ApiTestService apiTestService;

    @GetMapping("/")
    public ResponseEntity<List<ApiTest>> getAllApiTests(){
        return ResponseEntity.ok().body(apiTestService.getAllApiTests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiTest> getApiTestById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(apiTestService.getApiTestById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ApiTest>> searchApiTests(@RequestParam String query) {
        return ResponseEntity.ok().body(apiTestService.searchApiTests(query));
    }
    
    @PostMapping("/")
    public ResponseEntity<ApiTest> saveApiTest(@RequestBody ApiTest apiTest)
    {
        return ResponseEntity.ok().body(apiTestService.saveApiTest(apiTest));
    }

    @PutMapping("/")
    public ResponseEntity<ApiTest> updateApiTest(@RequestBody ApiTest apiTest)
    {
        return ResponseEntity.ok().body(apiTestService.updateApiTest(apiTest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApiTestById(@PathVariable UUID id)
    {
        apiTestService.deleteApiTestById(id);
        return ResponseEntity.ok().body("Deleted apiTest successfully");
    }


}
