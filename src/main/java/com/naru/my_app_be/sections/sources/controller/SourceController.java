package com.naru.my_app_be.sections.sources.controller;

import com.naru.my_app_be.sections.sources.entity.Source;
import com.naru.my_app_be.sections.sources.service.SourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sources/v1")
@RequiredArgsConstructor
@Validated
public class SourceController {

    private final SourceService sourceService;

    @GetMapping("/")
    public ResponseEntity<List<Source>> getAllSources(){
        return ResponseEntity.ok().body(sourceService.getAllSources());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Source> getSourceById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(sourceService.getSourceById(id));
    }
    
    @PostMapping("/")
    public ResponseEntity<Source> saveSource(@RequestBody Source source)
    {
        return ResponseEntity.ok().body(sourceService.saveSource(source));
    }

    @PutMapping("/")
    public ResponseEntity<Source> updateSource(@RequestBody Source source)
    {
        return ResponseEntity.ok().body(sourceService.updateSource(source));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSourceById(@PathVariable UUID id)
    {
        sourceService.deleteSourceById(id);
        return ResponseEntity.ok().body("Deleted source successfully");
    }


}
