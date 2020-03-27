package com.namdq.example.k8s.nnote.repository;

import com.namdq.example.k8s.nnote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, String> {
}
