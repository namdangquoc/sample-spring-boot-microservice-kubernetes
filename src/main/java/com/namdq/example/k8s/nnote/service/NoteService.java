package com.namdq.example.k8s.nnote.service;

import com.namdq.example.k8s.nnote.model.Note;

import java.util.List;

public interface NoteService {

    Note save(Note note);

    List<Note> findAll();
}
