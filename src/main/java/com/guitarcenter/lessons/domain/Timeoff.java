package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the TIMEOFF database table.
 *
 */
@Entity
@NamedQuery(name = "Timeoff.findAll", query = "SELECT t FROM Timeoff t")
public class Timeoff implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TIMEOFF_ID")
    private long timeoffId;

    @Column(name = "END_TIME")
    private Object endTime;

    @Column(name = "START_TIME")
    private Object startTime;

    private Object updated;

    @Column(name = "UPDATED_BY")
    private BigDecimal updatedBy;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Instructor
    @ManyToOne
    @JoinColumn(name = "INSTRUCTOR_ID")
    private Instructor instructor;

    public Timeoff() {}

    public long getTimeoffId() {
        return this.timeoffId;
    }

    public void setTimeoffId(long timeoffId) {
        this.timeoffId = timeoffId;
    }

    public Object getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public Object getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Object startTime) {
        this.startTime = startTime;
    }

    public Object getUpdated() {
        return this.updated;
    }

    public void setUpdated(Object updated) {
        this.updated = updated;
    }

    public BigDecimal getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(BigDecimal updatedBy) {
        this.updatedBy = updatedBy;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
