package com.zerobase.fastlms.image.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ImageController {

    @GetMapping("/files/{year}/{month}/{date}/{name}")
    public ResponseEntity<Resource> getImage(
        @PathVariable("year") String year,
        @PathVariable("month") String month,
        @PathVariable("date") String date,
        @PathVariable("name") String name
    ) throws IOException {
        String path = "/Users/kjn/Documents/workspace/fastlms3/src/main/resources/files" + "/" + year + "/" + month + "/" + date + "/" + name;
        FileSystemResource resource = new FileSystemResource(path);
        if (!resource.exists()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", Files.probeContentType(Paths.get(path)));
        return new ResponseEntity<>(resource, header, HttpStatus.OK);
    }
}
