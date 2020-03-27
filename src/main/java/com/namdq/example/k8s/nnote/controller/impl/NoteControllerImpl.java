package com.namdq.example.k8s.nnote.controller.impl;

import com.namdq.example.k8s.nnote.controller.NoteController;
import com.namdq.example.k8s.nnote.model.Note;
import com.namdq.example.k8s.nnote.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class NoteControllerImpl implements NoteController {

    @Autowired
    private NoteService noteService;

    @Override
    public String getAllNote(Model model) {
        List<Note> notes = noteService.findAll();
        Collections.reverse(notes);

        model.addAttribute("notes", notes);

        log.info("Model {}", model.asMap());

        return "home";
    }
}
