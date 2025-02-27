package com.astrapay.service;

import com.astrapay.dto.NoteRequestDto;
import com.astrapay.entity.Note;
import com.astrapay.exception.ResourceNotFoundException;
import com.astrapay.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note saveNote(NoteRequestDto noteDto) {

        Note note = Note.builder().title(noteDto.getTitle()).content(noteDto.getContent()).build();
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        if (!noteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Note with ID " + id + " not found");
        }
        noteRepository.deleteById(id);
    }
}
