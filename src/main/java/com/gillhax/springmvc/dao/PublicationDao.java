package com.gillhax.springmvc.dao;

import com.gillhax.springmvc.model.Psychologist;
import com.gillhax.springmvc.model.Publication;

import java.util.List;

/**
 * Created by alex on 26.07.2016.
 */

public interface PublicationDao {

    Publication findById(int id);

    List<Publication> findAllPublication();

    List<Publication> findPublicationsByPsychologist(Psychologist psychologist);

    void save(Publication publication);

    void deleteById(int id);

}
