package com.gillhax.springmvc.dao;

/**
 * Created by alex on 26.07.2016.
 */

import java.util.Collection;
import java.util.List;

import com.gillhax.springmvc.model.Psychologist;
import com.gillhax.springmvc.model.Publication;
import org.springframework.stereotype.Repository;

@Repository("publicationDao")
public class PublicationDaoImpl extends AbstractDao<Integer, Publication> implements PublicationDao {

    public Publication findById(int id) {
        return getByKey(id);
    }


    @SuppressWarnings("unchecked")
    public List<Publication> findAllPublication() {
        List<Publication> publications = getEntityManager()
                .createQuery("SELECT p FROM Publication p ORDER BY p.title ASC")
                .getResultList();
        return publications;
    }

    @SuppressWarnings("unchecked")
    public List<Publication> findPublicationsByPsychologist(Psychologist psychologist) {
        List<Publication> publications = getEntityManager()
                .createQuery("SELECT p FROM Publication p WHERE p.psychologist = :psychologist")
                .setParameter("psychologist", psychologist)
                .getResultList();
        return publications;
    }

    public void save(Publication publication) {
        persist(publication);
    }

    public void deleteById(int id) {
        delete(getByKey(id));
    }

}
