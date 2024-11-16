package com.naru.my_app_be.sections.sources.service;


import com.naru.my_app_be.sections.sources.entity.Source;
import com.naru.my_app_be.sections.sources.repository.SourceRepo;
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
public class SourceService {

    private final SourceRepo sourceRepo;

    public List<Source> getAllSources(){
        return sourceRepo.findAll();
    }

    public Source getSourceById(UUID id){
        Optional<Source> optionalSource = sourceRepo.findById(id);
        if(optionalSource.isPresent()){
            return optionalSource.get();
        }
        log.info("Source with id: {} doesn't exist", id);
        return null;
    }

    public Source saveSource (Source source){
        source.setCreatedAt(LocalDateTime.now());
        source.setUpdatedAt(LocalDateTime.now());
        Source savedSource = sourceRepo.save(source);

        log.info("Source with id: {} saved successfully", source.getId());
        return savedSource;
    }

    public Source updateSource (Source source) {
        Optional<Source> existingSource = sourceRepo.findById(source.getId());
        source.setCreatedAt(existingSource.get().getCreatedAt());
        source.setUpdatedAt(LocalDateTime.now());

        Source updatedSource = sourceRepo.save(source);

        log.info("Source with id: {} updated successfully", source.getId());
        return updatedSource;
    }

    public void deleteSourceById (UUID id) {
        sourceRepo.deleteById(id);
    }

}
