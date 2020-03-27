package com.namdq.example.k8s.nnote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public interface NoteController {

    @GetMapping("/")
    String getAllNote(Model model);
}
