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
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class NoteControllerImpl implements NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private FileService fileService;

    private InetAddress inetAddress;

    public NoteControllerImpl() {
        try {
            inetAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public String getAllNote(Model model) {
        List<Note> notes = noteService.findAll();
        Collections.reverse(notes);

        model.addAttribute("ip", inetAddress.getHostAddress());
        model.addAttribute("notes", notes);

        log.info("Model {}", model.asMap());

        return "home";
    }

    @Override
    public String createNote(Model model) {

        Note note = new Note();

        model.addAttribute("ip", inetAddress);
        model.addAttribute("note", note);

        return "note/create";
    }

    @Override
    public String createNote(Model model, String title, MultipartFile image, String description) throws Exception {
        if (title == null || title.trim().isEmpty()) {
            return "redirect:/";
        }

        Note note = new Note();
        note.setTitle(title);
        note.setDescription(description);

        if (image != null && image.getOriginalFilename() != null && !image.getOriginalFilename().isEmpty()) {
            String imagePath = "/uploads/";
            imagePath += fileService.uploadFile(image);
            note.setImage(imagePath);
        }

        noteService.create(note);

        return "redirect:/";
    }

}
