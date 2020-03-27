package com.namdq.example.k8s.nnote.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "nnote")
@Getter
public class NNoteProperties {

    @Value("${uploadDir:/tmp/uploads/}")
    private String uploadDir;

}
