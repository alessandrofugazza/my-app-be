package com.naru.my_app_be.playground.generalnotes.repository;

import com.naru.my_app_be.playground.generalnotes.entity.GeneralNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GeneralNoteRepo extends JpaRepository<GeneralNote, UUID> {
}