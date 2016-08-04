package com.gillhax.springmvc.service;

/**
 * Created by alex on 31.07.2016.
 */

    import java.util.List;

    import com.gillhax.springmvc.model.UserDocument;

public interface UserDocumentService {

    UserDocument findById(int id);

    List<UserDocument> findAll();

    List<UserDocument> findAllByUserId(int id);

    void saveDocument(UserDocument document);

    void deleteById(int id);

    void updateDocument(UserDocument userDocument);
}