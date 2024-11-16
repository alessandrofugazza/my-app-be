package com.naru.my_app_be.sections.notes.service;


import com.naru.my_app_be.sections.notes.entity.Note;
import com.naru.my_app_be.sections.notes.repository.NoteRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteService {

    private final NoteRepo noteRepo;

    public List<Note> getAllNotes(){
        return noteRepo.findAll();
    }

    public Note getNoteById(UUID id){
        Optional<Note> optionalNote = noteRepo.findById(id);
        if(optionalNote.isPresent()){
            return optionalNote.get();
        }
        log.info("Note with id: {} doesn't exist", id);
        return null;
    }

    public Note saveNote (Note note){
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        Note savedNote = noteRepo.save(note);

        log.info("Note with id: {} saved successfully", note.getId());
        return savedNote;
    }

    public Note updateNote (Note note) {
        Optional<Note> existingNote = noteRepo.findById(note.getId());
        note.setCreatedAt(existingNote.get().getCreatedAt());
        note.setUpdatedAt(LocalDateTime.now());

        Note updatedNote = noteRepo.save(note);

        log.info("Note with id: {} updated successfully", note.getId());
        return updatedNote;
    }

    public void deleteNoteById (UUID id) {
        noteRepo.deleteById(id);
    }

}
