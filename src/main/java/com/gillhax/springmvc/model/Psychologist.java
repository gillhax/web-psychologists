package com.gillhax.springmvc.model;

/**
 * Created by alex on 25.07.2016.
 */

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

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

    @OneToMany(mappedBy = "psychologist",  fetch = FetchType.EAGER)
    private List<Publication> publications;

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

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
        result = prime * result + ((about == null) ? 0 : about.hashCode());
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
        if (contacts == null) {
            if (other.contacts != null)
                return false;
        } else if (!contacts.equals(other.contacts))
            return false;
        if (about == null) {
            if (other.about != null)
                return false;
        } else if (!about.equals(other.about))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Psychologist [id=" + id + ", name=" + name + ", contacts=" + contacts + ", about=" + about + "]";
    }

}