package com.guitarcenter.lessons.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * A Courselines.
 */
@Entity
@Table(name = "courselines")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "courselines")
public class Courselines implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "courseline", length = 50, nullable = false)
    private String courseline;

    @Size(max = 4000)
    @Column(name = "textdescription", length = 4000)
    private String textdescription;

    @Lob
    @Column(name = "htmldescription")
    private String htmldescription;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_content_type")
    private String imageContentType;

    /*
     * @ManyToOne
     *
     * @JsonIgnoreProperties(value = "courselines", allowSetters = true) private
     * Courses courses;
     */

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseline() {
        return courseline;
    }

    public Courselines courseline(String courseline) {
        this.courseline = courseline;
        return this;
    }

    public void setCourseline(String courseline) {
        this.courseline = courseline;
    }

    public String getTextdescription() {
        return textdescription;
    }

    public Courselines textdescription(String textdescription) {
        this.textdescription = textdescription;
        return this;
    }

    public void setTextdescription(String textdescription) {
        this.textdescription = textdescription;
    }

    public String getHtmldescription() {
        return htmldescription;
    }

    public Courselines htmldescription(String htmldescription) {
        this.htmldescription = htmldescription;
        return this;
    }

    public void setHtmldescription(String htmldescription) {
        this.htmldescription = htmldescription;
    }

    public byte[] getImage() {
        return image;
    }

    public Courselines image(byte[] image) {
        this.image = image;
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public Courselines imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    /*
     * public Courses getCourses() { return courses; }
     *
     * public Courselines courses(Courses courses) { this.courses = courses; return
     * this; }
     *
     * public void setCourses(Courses courses) { this.courses = courses; }
     */
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Courselines)) {
            return false;
        }
        return id != null && id.equals(((Courselines) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Courselines{" +
            "id=" + getId() +
            ", courseline='" + getCourseline() + "'" +
            ", textdescription='" + getTextdescription() + "'" +
            ", htmldescription='" + getHtmldescription() + "'" +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + getImageContentType() + "'" +
            "}";
    }
}
