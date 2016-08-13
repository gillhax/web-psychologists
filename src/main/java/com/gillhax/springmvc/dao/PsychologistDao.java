package com.gillhax.springmvc.dao;

import com.gillhax.springmvc.model.Psychologist;

import java.util.List;

/**
 * Created by alex on 26.07.2016.
 */

public interface PsychologistDao {

    Psychologist findById(int id);

    Psychologist findByUsername(String username);

    List<Psychologist> findAllPsychologist();

    void save(Psychologist psychologist);

    void deleteById(int id);

    boolean isUsernameUnique(Integer id, String username);
}
