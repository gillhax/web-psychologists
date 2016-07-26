package com.gillhax.springmvc.dao;

import com.gillhax.springmvc.model.Psychologist;

import java.util.List;

/**
 * Created by alex on 26.07.2016.
 */

public interface PsychologistDao {

    public Psychologist findById(int id);

    public List<Psychologist> findAllPsychologist();

    void save(Psychologist psychologist);

    void deleteById(int id);

}
