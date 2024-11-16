package com.naru.my_app_be.sections.learnsubjects.controller;

import com.naru.my_app_be.sections.learnsubjects.entity.LearnSubject;
import com.naru.my_app_be.sections.learnsubjects.service.LearnSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/learn/v1")
@RequiredArgsConstructor
@Validated
public class LearnSubjectController {

    private final LearnSubjectService learnSubjectService;

    @GetMapping("/")
    public ResponseEntity<List<LearnSubject>> getAllLearnSubjects(){
        return ResponseEntity.ok().body(learnSubjectService.getAllLearnSubjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearnSubject> getLearnSubjectById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(learnSubjectService.getLearnSubjectById(id));
    }
    
    @PostMapping("/")
    public ResponseEntity<LearnSubject> saveLearnSubject(@RequestBody LearnSubject learnSubject)
    {
        return ResponseEntity.ok().body(learnSubjectService.saveLearnSubject(learnSubject));
    }

    // CHECK why is a put being handled without id
    @PutMapping("/")
    public ResponseEntity<LearnSubject> updateLearnSubject(@RequestBody LearnSubject learnSubject)
    {
        return ResponseEntity.ok().body(learnSubjectService.updateLearnSubject(learnSubject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLearnSubjectById(@PathVariable UUID id)
    {
        learnSubjectService.deleteLearnSubjectById(id);
        return ResponseEntity.ok().body("Deleted Learn Subject successfully");
    }


}
