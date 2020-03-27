package com.namdq.example.k8s.nnote.service.impl;

import com.namdq.example.k8s.nnote.model.Note;
import com.namdq.example.k8s.nnote.repository.NoteRepository;
import com.namdq.example.k8s.nnote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }
}
