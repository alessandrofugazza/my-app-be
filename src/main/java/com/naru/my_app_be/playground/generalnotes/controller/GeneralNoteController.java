package com.naru.my_app_be.playground.generalnotes.controller;

import com.naru.my_app_be.playground.generalnotes.entity.GeneralNote;
import com.naru.my_app_be.playground.generalnotes.service.GeneralNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/general-notes/v1")
@RequiredArgsConstructor
@Validated
public class GeneralNoteController {

    private final GeneralNoteService generalNoteService;

    @GetMapping("/")
    public ResponseEntity<List<GeneralNote>> getAllGeneralNotes(){
        return ResponseEntity.ok().body(generalNoteService.getAllGeneralNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralNote> getGeneralNoteById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(generalNoteService.getGeneralNoteById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<GeneralNote>> searchGeneralNotes(@RequestParam String query) {
        return ResponseEntity.ok().body(generalNoteService.searchGeneralNotes(query));
    }

    @PostMapping("/")
    public ResponseEntity<GeneralNote> saveGeneralNote(@RequestBody GeneralNote generalNote)
    {
        return ResponseEntity.ok().body(generalNoteService.saveGeneralNote(generalNote));
    }

    @PutMapping("/")
    public ResponseEntity<GeneralNote> updateGeneralNote(@RequestBody GeneralNote generalNote)
    {
        return ResponseEntity.ok().body(generalNoteService.updateGeneralNote(generalNote));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGeneralNoteById(@PathVariable UUID id)
    {
        generalNoteService.deleteGeneralNoteById(id);
        return ResponseEntity.ok().body("Deleted generalNote successfully");
    }

}