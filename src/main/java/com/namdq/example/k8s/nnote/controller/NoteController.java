package com.namdq.example.k8s.nnote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public interface NoteController {

    @GetMapping("/")
    String getAllNote(Model model);

    @GetMapping("/notes/create")
    String createNote(Model model);

    @PostMapping("/notes/create")
    String createNote(Model model, @RequestParam("title") String title, @RequestParam("image") MultipartFile image, @RequestParam("description") String description) throws Exception;
}
