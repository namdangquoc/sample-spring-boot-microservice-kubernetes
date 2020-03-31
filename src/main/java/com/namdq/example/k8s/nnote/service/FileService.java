package com.namdq.example.k8s.nnote.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadFile(MultipartFile multipartFile) throws Exception;
}
