package com.gillhax.springmvc.dao;

/**
 * Created by alex on 26.07.2016.
 */

import java.util.Collection;
import java.util.List;

import com.gillhax.springmvc.model.Psychologist;
import org.springframework.stereotype.Repository;

@Repository("psychologistDao")
public class PsychologistDaoImpl extends AbstractDao<Integer, Psychologist> implements PsychologistDao {

    public Psychologist findById(int id) {
        Psychologist psychologist = getByKey(id);
        if(psychologist!=null){
            initializeCollection(psychologist.getPublications());
        }
        return psychologist;
    }


    @SuppressWarnings("unchecked")
    public List<Psychologist> findAllPsychologist() {
        List<Psychologist> psychologists = getEntityManager()
                .createQuery("SELECT p FROM Psychologist p ORDER BY p.name ASC")
                .getResultList();
        return psychologists;
    }

    public void save(Psychologist psychologist) {
        persist(psychologist);
    }

    public void deleteById(int id) {
        delete(getByKey(id));
    }

    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }

}