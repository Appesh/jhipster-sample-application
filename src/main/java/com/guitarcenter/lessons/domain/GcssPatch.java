package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the GCSS_PATCHES database table.
 *
 */
@Entity
@Table(name = "GCSS_PATCHES")
@NamedQuery(name = "GcssPatch.findAll", query = "SELECT g FROM GcssPatch g")
public class GcssPatch implements Serializable {
    private static final long serialVersionUID = 1L;

    private Object applied;

    private String description;

    public GcssPatch() {}

    public Object getApplied() {
        return this.applied;
    }

    public void setApplied(Object applied) {
        this.applied = applied;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
