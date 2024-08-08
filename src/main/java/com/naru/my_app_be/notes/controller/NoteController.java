package com.naru.my_app_be.notes.controller;

import com.naru.my_app_be.notes.entity.Note;
import com.naru.my_app_be.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notes/v1")
@RequiredArgsConstructor
@Validated
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/")
    public ResponseEntity<List<Note>> getAllNotes(){
        return ResponseEntity.ok().body(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(noteService.getNoteById(id));
    }
    
    @PostMapping("/")
    public ResponseEntity<Note> saveNote(@RequestBody Note note)
    {
        return ResponseEntity.ok().body(noteService.saveNote(note));
    }

    // CHECK why is a put being handled without id
    @PutMapping("/")
    public ResponseEntity<Note> updateNote(@RequestBody Note note)
    {
        return ResponseEntity.ok().body(noteService.updateNote(note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable UUID id)
    {
        noteService.deleteNoteById(id);
        return ResponseEntity.ok().body("Deleted note successfully");
    }


}
