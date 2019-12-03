package com.neil.stickynotes.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.neil.stickynotes.bo.NotesBo;
import com.neil.stickynotes.dao.entity.Notes;
import com.neil.stickynotes.dao.repository.NotesRepository;
import com.neil.stickynotes.exception.BizException;
import com.neil.stickynotes.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Override
    @Transactional
    public NotesBo saveNewNotes(NotesBo notes) {
        Notes note = new Notes();
        note.setNotes(notes.getNotes());
        notesRepository.save(note);
        return NotesBo.valueOf(note);
    }

    @Override
    @Transactional
    public NotesBo updateNotes(NotesBo notesBo) {
        Notes note = notesRepository.findById(notesBo.getId()).orElseThrow(() -> new BizException("Notes is not found."));
        note.setNotes(notesBo.getNotes());
        note.setUpdateDatetime(new Date());
        notesRepository.save(note);
        return NotesBo.valueOf(note);
    }

    @Override
    @Transactional
    public void deleteNotes(Integer id) {
        notesRepository.deleteById(id);
    }

    @Override
    public List<NotesBo> getNotes() {
        return notesRepository.findAllByOrderByUpdateDatetimeDesc().stream().map(NotesBo::valueOf).collect(Collectors.toList());
    }
}
