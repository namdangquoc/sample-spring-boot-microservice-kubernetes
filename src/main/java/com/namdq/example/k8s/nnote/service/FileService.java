package com.namdq.example.k8s.nnote.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String uploadFile(MultipartFile multipartFile) throws IOException;
}
