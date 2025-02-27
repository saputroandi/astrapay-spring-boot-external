package com.astrapay.controller;

import com.astrapay.dto.NoteRequestDto;
import com.astrapay.dto.NoteResponseDto;
import com.astrapay.entity.Note;
import com.astrapay.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        log.info("get all note");

        return noteService.getAllNotes();
    }

    @PostMapping
    public NoteResponseDto createNote(@Validated @RequestBody NoteRequestDto noteDto) {
        log.info("create new note");
        Note note = noteService.saveNote(noteDto);

        return NoteResponseDto.builder().id(note.getId()).title(note.getTitle()).content(note.getTitle()).build();
    }

    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable Long id) {
        log.info("delete note by id: " + id);

        noteService.deleteNoteById(id);
    }
}
