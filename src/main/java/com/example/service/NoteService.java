package com.example.service;

import com.example.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class NoteService {
    private final List<Note> noteList = new ArrayList<>();


    List<Note> listAll() {
        return noteList;
    }

    Note add(Note note) {
        long id = generatePositiveRandomLong();
        note.setId(id);
        noteList.add(note);
        return note;
    }

    void deleteById(long id) {
        Optional<Note> noteRemoveById = noteList.stream()
                .filter(note -> note.getId() == id)
                .findFirst();
        if (noteRemoveById.isPresent()) {
            noteList.remove(noteRemoveById.get());
        } else {
            throw new NoSuchElementException("Notes are id [" + id + "] does not exist.");
        }
    }

    void update(Note note) {
        Optional<Note> optionalNote = noteList.stream()
                .filter(n -> Objects.equals(n.getId(), note.getId()))
                .findFirst();
        if (optionalNote.isPresent()) {
            Note foundNote = optionalNote.get();
            foundNote.setTitle(note.getTitle());
            foundNote.setContent(note.getContent());
        } else {
            throw new NoSuchElementException("Notes are id [" + note.getId() + "] does not exist.");
        }
    }

    Note getById(long id) {
        return noteList.stream()
                .filter(note -> note.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Notes are id [" + id + "] does not exist."));
    }

    private static long generatePositiveRandomLong() {
        return ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
    }
}
