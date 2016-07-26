package com.gillhax.springmvc.service;

import com.gillhax.springmvc.model.Publication;

import java.util.List;

/**
 * Created by alex on 26.07.2016.
 */
public interface PublicationService {

    Publication findById(int id);

    void savePublication(Publication publication);

    void updatePublication(Publication publication);

    void deletePublicationById(int id);

    List<Publication> findAllPublication();

}
