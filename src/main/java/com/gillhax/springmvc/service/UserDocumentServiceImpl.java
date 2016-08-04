package com.gillhax.springmvc.service;

/**
 * Created by alex on 31.07.2016.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gillhax.springmvc.dao.UserDocumentDao;
import com.gillhax.springmvc.model.UserDocument;

@Service("userDocumentService")
@Transactional
public class UserDocumentServiceImpl implements UserDocumentService{

    @Autowired
    UserDocumentDao dao;

    public UserDocument findById(int id) {
        return dao.findById(id);
    }

    public List<UserDocument> findAll() {
        return dao.findAll();
    }

    public List<UserDocument> findAllByUserId(int userId) {
        return dao.findAllByUserId(userId);
    }

    public void saveDocument(UserDocument document){
        dao.save(document);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }

    public void updateDocument(UserDocument userDocument) {
        UserDocument entity = dao.findById(userDocument.getId());
        if(entity!=null){
            entity.setName(userDocument.getName());
            entity.setType(userDocument.getType());
            entity.setContent(userDocument.getContent());
            entity.setPsychologist(userDocument.getPsychologist());
        }
    }

}