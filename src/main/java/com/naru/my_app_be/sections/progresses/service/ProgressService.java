package com.naru.my_app_be.sections.progresses.service;


import com.naru.my_app_be.sections.progresses.entity.Progress;
import com.naru.my_app_be.sections.progresses.repository.ProgressRepo;
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
public class ProgressService {

    private final ProgressRepo progressRepo;

    public List<Progress> getAllProgresses(){
        return progressRepo.findAll();
    }

    public Progress getProgressById(UUID id){
        Optional<Progress> optionalProgress = progressRepo.findById(id);
        if(optionalProgress.isPresent()){
            return optionalProgress.get();
        }
        log.info("Progress with id: {} doesn't exist", id);
        return null;
    }

    public Progress saveProgress (Progress progress){
        progress.setCreatedAt(LocalDateTime.now());
        progress.setUpdatedAt(LocalDateTime.now());
        Progress savedProgress = progressRepo.save(progress);

        log.info("Progress with id: {} saved successfully", progress.getId());
        return savedProgress;
    }

    public Progress updateProgress (Progress progress) {
        Optional<Progress> existingProgress = progressRepo.findById(progress.getId());
        progress.setCreatedAt(existingProgress.get().getCreatedAt());
        progress.setUpdatedAt(LocalDateTime.now());

        Progress updatedProgress = progressRepo.save(progress);

        log.info("Progress with id: {} updated successfully", progress.getId());
        return updatedProgress;
    }

    public void deleteProgressById (UUID id) {
        progressRepo.deleteById(id);
    }

}
