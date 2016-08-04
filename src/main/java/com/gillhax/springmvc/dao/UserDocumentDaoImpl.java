package com.gillhax.springmvc.dao;

/**
 * Created by alex on 31.07.2016.
 */

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gillhax.springmvc.model.UserDocument;

@Repository("userDocumentDao")
public class UserDocumentDaoImpl extends AbstractDao<Integer, UserDocument> implements UserDocumentDao{

    @SuppressWarnings("unchecked")
    public List<UserDocument> findAll() {
        List<UserDocument> userDocuments = getEntityManager()
                .createQuery("SELECT p FROM UserDocument")
                .getResultList();
        return userDocuments;
    }

    public void save(UserDocument document) {
        persist(document);
    }


    public UserDocument findById(int id) {
            return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<UserDocument> findAllByUserId(int userId){
        List<UserDocument> userDocuments = getEntityManager()
                .createQuery("SELECT p FROM UserDocument p WHERE p.psychologist.id = :userId")
                .setParameter("userId", userId)
                .getResultList();
        return userDocuments;
    }


    public void deleteById(int id) {
        UserDocument document =  getByKey(id);
        delete(document);
    }


}