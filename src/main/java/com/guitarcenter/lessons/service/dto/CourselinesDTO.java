package com.guitarcenter.lessons.service.dto;

import java.io.Serializable;
import javax.persistence.Lob;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.guitarcenter.lessons.domain.Courselines} entity.
 */
public class CourselinesDTO implements Serializable {
    private Long id;

    @NotNull
    @Size(max = 50)
    private String courseline;

    @Size(max = 4000)
    private String textdescription;

    @Lob
    private String htmldescription;

    @Lob
    private byte[] image;

    private String imageContentType;

    private Long coursesId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseline() {
        return courseline;
    }

    public void setCourseline(String courseline) {
        this.courseline = courseline;
    }

    public String getTextdescription() {
        return textdescription;
    }

    public void setTextdescription(String textdescription) {
        this.textdescription = textdescription;
    }

    public String getHtmldescription() {
        return htmldescription;
    }

    public void setHtmldescription(String htmldescription) {
        this.htmldescription = htmldescription;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public Long getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(Long coursesId) {
        this.coursesId = coursesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourselinesDTO)) {
            return false;
        }

        return id != null && id.equals(((CourselinesDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CourselinesDTO{" +
            "id=" + getId() +
            ", courseline='" + getCourseline() + "'" +
            ", textdescription='" + getTextdescription() + "'" +
            ", htmldescription='" + getHtmldescription() + "'" +
            ", image='" + getImage() + "'" +
            ", coursesId=" + getCoursesId() +
            "}";
    }
}
