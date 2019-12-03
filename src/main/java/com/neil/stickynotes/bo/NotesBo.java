package com.neil.stickynotes.bo;
import com.neil.stickynotes.dao.entity.Notes;

public class NotesBo {
    private Integer id;
    private String notes;
    private Long time;

    public NotesBo() {
    }

    public NotesBo(Integer id, String notes, Long time) {
        this.id = id;
        this.notes = notes;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public static NotesBo valueOf(Notes notes) {
        return new NotesBo(notes.getId(), notes.getNotes(), notes.getUpdateDatetime().getTime());
    }
}
