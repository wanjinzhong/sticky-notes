package com.neil.stickynotes.service;
import java.util.List;

import com.neil.stickynotes.bo.NotesBo;

public interface NotesService {
    NotesBo saveNewNotes(NotesBo notes);

    NotesBo updateNotes(NotesBo notesBo);

    void deleteNotes(Integer id);

    List<NotesBo> getNotes();
}
