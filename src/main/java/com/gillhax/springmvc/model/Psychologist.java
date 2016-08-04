package com.gillhax.springmvc.model;

/**
 * Created by alex on 25.07.2016.
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="PSYCHOLOGIST")
public class Psychologist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PSYCHOLOGIST_ID")
    private Integer id;

    @NotEmpty
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "CONTACTS", nullable = false)
    private String contacts;

    @NotEmpty
    @Column(name = "ABOUT", nullable = false)
    private String about;

    @NotNull
    @Column(name = "PHOTO", nullable = false)
    private String photo;

    @OneToMany(mappedBy = "psychologist",  fetch = FetchType.EAGER)
    private List<Publication> publications;

    @OneToMany(mappedBy = "psychologist", cascade = CascadeType.ALL)
    private Set<UserDocument> userDocuments = new HashSet<UserDocument>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public Set<UserDocument> getUserDocuments() {
        return userDocuments;
    }

    public void setUserDocuments(Set<UserDocument> userDocuments) {
        this.userDocuments = userDocuments;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Psychologist))
            return false;
        Psychologist other = (Psychologist) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Psychologist [id=" + id + ", name=" + name + ", contacts=" + contacts + ", about=" + about + "]";
    }

}