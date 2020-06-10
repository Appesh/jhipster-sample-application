package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the TUTORIALS database table.
 *
 */
@Entity
@Table(name = "TUTORIALS")
@NamedQuery(name = "Tutorial.findAll", query = "SELECT t FROM Tutorial t")
public class Tutorial implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;

    private BigDecimal published;

    private String title;

    public Tutorial() {}

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPublished() {
        return this.published;
    }

    public void setPublished(BigDecimal published) {
        this.published = published;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
