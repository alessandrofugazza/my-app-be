package com.naru.my_app_be.sections.learnsubjects.service;


import com.naru.my_app_be.sections.learnsubjects.entity.LearnSubject;
import com.naru.my_app_be.sections.learnsubjects.repository.LearnSubjectRepo;
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
public class LearnSubjectService {

    private final LearnSubjectRepo learnSubjectRepo;

    public List<LearnSubject> getAllLearnSubjects(){
        return learnSubjectRepo.findAll();
    }

    public LearnSubject getLearnSubjectById(UUID id){
        Optional<LearnSubject> optionalLearnSubject = learnSubjectRepo.findById(id);
        if(optionalLearnSubject.isPresent()){
            return optionalLearnSubject.get();
        }
        log.info("LearnSubject with id: {} doesn't exist", id);
        return null;
    }

    public LearnSubject saveLearnSubject (LearnSubject learnSubject){
        learnSubject.setCreatedAt(LocalDateTime.now());
        learnSubject.setUpdatedAt(LocalDateTime.now());
        LearnSubject savedLearnSubject = learnSubjectRepo.save(learnSubject);

        log.info("LearnSubject with id: {} saved successfully", learnSubject.getId());
        return savedLearnSubject;
    }

    public LearnSubject updateLearnSubject (LearnSubject learnSubject) {
        Optional<LearnSubject> existingLearnSubject = learnSubjectRepo.findById(learnSubject.getId());
        learnSubject.setCreatedAt(existingLearnSubject.get().getCreatedAt());
        learnSubject.setUpdatedAt(LocalDateTime.now());

        LearnSubject updatedLearnSubject = learnSubjectRepo.save(learnSubject);

        log.info("LearnSubject with id: {} updated successfully", learnSubject.getId());
        return updatedLearnSubject;
    }

    public void deleteLearnSubjectById (UUID id) {
        learnSubjectRepo.deleteById(id);
    }

}
