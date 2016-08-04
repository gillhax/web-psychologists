package com.gillhax.springmvc.model;

/**
 * Created by alex on 25.07.2016.
 */

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="PUBLICATION")
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PUBLICATION_ID")
    private Integer id;

    @NotEmpty
    @Column(name = "TITLE", nullable = false)
    private String title;

    @NotEmpty
    @Lob
    @Column(name = "CONTENT", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PROBLEM_ID")
    private Problem problem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "PSYCHOLOGIST_ID")
    private Psychologist psychologist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Psychologist getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(Psychologist psychologist) {
        this.psychologist = psychologist;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Publication))
            return false;
        Publication other = (Publication) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Publication [id=" + id + ", title=" + title + "]";
    }

}

