package com.neil.stickynotes.web;

import java.util.List;

import com.neil.stickynotes.bo.NotesBo;
import com.neil.stickynotes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("public/api/notes")
public class NotesApi {

    @Autowired
    private NotesService notesService;

    @PostMapping()
    public NotesBo saveNewNotes(@RequestBody NotesBo notesBo) {
        return notesService.saveNewNotes(notesBo);
    }

    @PutMapping()
    public String updateNotes(@RequestBody NotesBo notesBo) {
        notesService.updateNotes(notesBo);
        return "OK";
    }

    @DeleteMapping("{id}")
    public String deleteNotes(@PathVariable("id") Integer id) {
        notesService.deleteNotes(id);
        return "OK";
    }

    @GetMapping()
    public List<NotesBo> getNotes() {
        return notesService.getNotes();
    }
}
