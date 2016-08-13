package com.gillhax.springmvc.service;

import com.gillhax.springmvc.dao.PublicationDao;
import com.gillhax.springmvc.model.Psychologist;
import com.gillhax.springmvc.model.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by alex on 26.07.2016.
 */

@Service("publicationService")
@Transactional
public class PublicationServiceImpl implements PublicationService {

    @Autowired
    private PublicationDao dao;

    public Publication findById(int id) {
        return dao.findById(id);
    }

    public void savePublication(Publication publication) {
        dao.save(publication);
    }

    public void updatePublication(Publication publication) {
        Publication entity = dao.findById(publication.getId());
        if(entity!=null){
            entity.setTitle(publication.getTitle());
            entity.setContent(publication.getContent());
            entity.setProblem(publication.getProblem());
            entity.setPsychologist(publication.getPsychologist());
        }
    }


    public void deletePublicationById(int id) {
        dao.deleteById(id);
    }

    public List<Publication> findAllPublication() {
        return dao.findAllPublication();
    }

    public List<Publication> findPublicationsByPsychologist(Psychologist psychologist) {
        return  dao.findPublicationsByPsychologist(psychologist);
    }

}
