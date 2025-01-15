package com.naru.my_app_be.playground.generalnotes.service;

import com.naru.my_app_be.playground.generalnotes.entity.GeneralNote;
import com.naru.my_app_be.playground.generalnotes.repository.GeneralNoteRepo;
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
public class GeneralNoteService {

    private final GeneralNoteRepo generalNoteRepo;

    public List<GeneralNote> getAllGeneralNotes(){
        return generalNoteRepo.findAll();
    }

    public List<GeneralNote> searchGeneralNotes(String query) {
        return generalNoteRepo.findAll().stream()
                .filter(generalNote -> generalNote.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public GeneralNote getGeneralNoteById(UUID id){
        Optional<GeneralNote> optionalGeneralNote = generalNoteRepo.findById(id);
        if(optionalGeneralNote.isPresent()){
            return optionalGeneralNote.get();
        }
        log.info("GeneralNote with id: {} doesn't exist", id);
        return null;
    }

    public GeneralNote saveGeneralNote (GeneralNote generalNote){
        generalNote.setCreatedAt(LocalDateTime.now());
        generalNote.setUpdatedAt(LocalDateTime.now());
        GeneralNote savedGeneralNote = generalNoteRepo.save(generalNote);

        log.info("GeneralNote with id: {} saved successfully", generalNote.getId());
        return savedGeneralNote;
    }

    public GeneralNote updateGeneralNote (GeneralNote generalNote) {
        Optional<GeneralNote> existingGeneralNote = generalNoteRepo.findById(generalNote.getId());
        generalNote.setCreatedAt(existingGeneralNote.get().getCreatedAt());
        generalNote.setUpdatedAt(LocalDateTime.now());

        GeneralNote updatedGeneralNote = generalNoteRepo.save(generalNote);

        log.info("GeneralNote with id: {} updated successfully", generalNote.getId());
        return updatedGeneralNote;
    }

    public void deleteGeneralNoteById (UUID id) {
        generalNoteRepo.deleteById(id);
    }

}