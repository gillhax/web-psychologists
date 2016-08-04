package com.gillhax.springmvc.dao;

import com.gillhax.springmvc.model.UserDocument;

import java.util.List;

/**
 * Created by alex on 31.07.2016.
 */
public interface UserDocumentDao {

    List<UserDocument> findAll();

    UserDocument findById(int id);

    void save(UserDocument document);

    List<UserDocument> findAllByUserId(int userId);

    void deleteById(int id);

}
