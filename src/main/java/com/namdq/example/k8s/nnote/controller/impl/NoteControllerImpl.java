package com.namdq.example.k8s.nnote.controller.impl;

import com.namdq.example.k8s.nnote.controller.NoteController;
import com.namdq.example.k8s.nnote.model.Note;
import com.namdq.example.k8s.nnote.service.FileService;
import com.namdq.example.k8s.nnote.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class NoteControllerImpl implements NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private FileService fileService;

    @Override
    public String getAllNote(Model model) {
        List<Note> notes = noteService.findAll();
        Collections.reverse(notes);

        model.addAttribute("notes", notes);

        log.info("Model {}", model.asMap());

        return "home";
    }

    @Override
    public String createNote(Model model) {

        Note note = new Note();

        model.addAttribute("note", note);

        return "note/create";
    }

    @Override
    public String createNote(Model model, String title, MultipartFile image, String description) {
        String imagePath = "/uploads/";
        try {
            imagePath += fileService.uploadFile(image);
        } catch (IOException e) {
            log.error("Upload image failed: {}, {}, {}", title, image.getOriginalFilename(), description);
        }

        Note note = new Note();
        note.setTitle(title);
        note.setDescription(description);
        note.setImage(imagePath);

        noteService.create(note);

        return "redirect:/";
    }

}
