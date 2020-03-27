package com.namdq.example.k8s.nnote.service;

import com.namdq.example.k8s.nnote.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {

    Note create(Note note);

    List<Note> findAll();
}
