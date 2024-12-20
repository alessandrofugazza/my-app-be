package com.naru.my_app_be.sections.notes.repository;

import com.naru.my_app_be.sections.notes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteRepo extends JpaRepository<Note, UUID> {
}

