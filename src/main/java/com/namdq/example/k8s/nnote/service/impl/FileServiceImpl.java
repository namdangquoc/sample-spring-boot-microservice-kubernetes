package com.namdq.example.k8s.nnote.service.impl;

import com.namdq.example.k8s.nnote.config.NNoteProperties;
import com.namdq.example.k8s.nnote.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private NNoteProperties nNoteProperties;

    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        File uploadsDir = new File(nNoteProperties.getUploadDir());
        if (!uploadsDir.exists()) {
            uploadsDir.mkdir();
        }

        String fileId = UUID.randomUUID().toString() + "."
                + Objects.requireNonNull(multipartFile.getOriginalFilename()).split("\\.")[1];
        multipartFile.transferTo(new File(nNoteProperties.getUploadDir() + fileId));

        return fileId;
    }


}
