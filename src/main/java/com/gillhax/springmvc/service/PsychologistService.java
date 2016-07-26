package com.gillhax.springmvc.service;

import com.gillhax.springmvc.model.Psychologist;

import java.util.List;

/**
 * Created by alex on 26.07.2016.
 */
public interface PsychologistService {

    Psychologist findById(int id);

    void savePsychologist(Psychologist psychologist);

    void updatePsychologist(Psychologist psychologist);

    void deletePsychologistById(int id);

    List<Psychologist> findAllPsychologist();

}
