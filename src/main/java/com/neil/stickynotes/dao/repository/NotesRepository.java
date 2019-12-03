package com.neil.stickynotes.dao.repository;

import java.util.List;

import com.neil.stickynotes.dao.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes, Integer> {
    List<Notes> findAllByOrderByUpdateDatetimeDesc();
}
