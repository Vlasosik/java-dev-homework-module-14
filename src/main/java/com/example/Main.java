package com.example;

import com.example.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Main {
    private final NoteService noteService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

