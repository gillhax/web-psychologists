package com.gillhax.springmvc.dao;

import com.gillhax.springmvc.model.Publication;

import java.util.List;

/**
 * Created by alex on 26.07.2016.
 */

public interface PublicationDao {

    public Publication findById(int id);

    public List<Publication> findAllPublication();

    void save(Publication publication);

    void deleteById(int id);

}
