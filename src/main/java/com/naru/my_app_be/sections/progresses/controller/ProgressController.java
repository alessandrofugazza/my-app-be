package com.naru.my_app_be.sections.progresses.controller;

import com.naru.my_app_be.sections.progresses.entity.Progress;
import com.naru.my_app_be.sections.progresses.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/progresses/v1")
@RequiredArgsConstructor
@Validated
public class ProgressController {

    private final ProgressService progressService;

    @GetMapping("/")
    public ResponseEntity<List<Progress>> getAllProgresses(){
        return ResponseEntity.ok().body(progressService.getAllProgresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progress> getProgressById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(progressService.getProgressById(id));
    }
    
    @PostMapping("/")
    public ResponseEntity<Progress> saveProgress(@RequestBody Progress progress)
    {
        return ResponseEntity.ok().body(progressService.saveProgress(progress));
    }

    // CHECK why is a put being handled without id
    @PutMapping("/")
    public ResponseEntity<Progress> updateProgress(@RequestBody Progress progress)
    {
        return ResponseEntity.ok().body(progressService.updateProgress(progress));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProgressById(@PathVariable UUID id)
    {
        progressService.deleteProgressById(id);
        return ResponseEntity.ok().body("Deleted progress successfully");
    }


}
