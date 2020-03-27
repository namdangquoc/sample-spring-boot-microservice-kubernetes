package com.namdq.example.k8s.nnote.controller;

import com.namdq.example.k8s.nnote.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public interface NoteController {

    @GetMapping("/")
    String getAllNote(Model model);

    @GetMapping("/notes/create")
    String createNote(Model model);

    @PostMapping("/notes/create")
    String createNote(Model model, @ModelAttribute Note note);
}
