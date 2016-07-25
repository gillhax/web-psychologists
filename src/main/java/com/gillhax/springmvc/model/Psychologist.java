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

    @OneToMany(mappedBy = "psychologist", cascade = CascadeType.ALL)
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
        return "Psychologist [id=" + id + ", name=" + name + "]";
    }

}