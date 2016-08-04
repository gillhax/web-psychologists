package com.gillhax.springmvc.service;

import com.gillhax.springmvc.dao.PsychologistDao;
import com.gillhax.springmvc.model.Psychologist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alex on 26.07.2016.
 */

@Service("psychologistService")
@Transactional
public class PsychologistServiceImpl implements PsychologistService{

    @Autowired
    private PsychologistDao dao;

    public Psychologist findById(int id) {
        return dao.findById(id);
    }

    public void savePsychologist(Psychologist psychologist) {
        dao.save(psychologist);
    }

    public void updatePsychologist(Psychologist psychologist) {
        Psychologist entity = dao.findById(psychologist.getId());
        if(entity!=null){
            entity.setName(psychologist.getName());
            entity.setContacts(psychologist.getContacts());
            entity.setAbout(psychologist.getAbout());
            entity.setPhoto(psychologist.getPhoto());
        }
    }


    public void deletePsychologistById(int id) {
        dao.deleteById(id);
    }

    public List<Psychologist> findAllPsychologist() {
        return dao.findAllPsychologist();
    }

}