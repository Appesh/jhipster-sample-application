package com.guitarcenter.lessons.service.dto;

import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.BooleanFilter;
import io.github.jhipster.service.filter.DoubleFilter;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.FloatFilter;
import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import java.io.Serializable;
import java.util.Objects;

/**
 * Criteria class for the {@link com.guitarcenter.lessons.domain.Courselines} entity. This class is used
 * in {@link com.guitarcenter.lessons.web.rest.CourselinesResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /courselines?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CourselinesCriteria implements Serializable, Criteria {
    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter courseline;

    private StringFilter textdescription;

    private LongFilter coursesId;

    public CourselinesCriteria() {}

    public CourselinesCriteria(CourselinesCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.courseline = other.courseline == null ? null : other.courseline.copy();
        this.textdescription = other.textdescription == null ? null : other.textdescription.copy();
        this.coursesId = other.coursesId == null ? null : other.coursesId.copy();
    }

    @Override
    public CourselinesCriteria copy() {
        return new CourselinesCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getCourseline() {
        return courseline;
    }

    public void setCourseline(StringFilter courseline) {
        this.courseline = courseline;
    }

    public StringFilter getTextdescription() {
        return textdescription;
    }

    public void setTextdescription(StringFilter textdescription) {
        this.textdescription = textdescription;
    }

    public LongFilter getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(LongFilter coursesId) {
        this.coursesId = coursesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CourselinesCriteria that = (CourselinesCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(courseline, that.courseline) &&
            Objects.equals(textdescription, that.textdescription) &&
            Objects.equals(coursesId, that.coursesId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseline, textdescription, coursesId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CourselinesCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (courseline != null ? "courseline=" + courseline + ", " : "") +
                (textdescription != null ? "textdescription=" + textdescription + ", " : "") +
                (coursesId != null ? "coursesId=" + coursesId + ", " : "") +
            "}";
    }
}
