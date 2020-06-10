package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the INSTRUCTOR_APPOINTMENT_STATUS database table.
 *
 */
@Entity
@Table(name = "INSTRUCTOR_APPOINTMENT_STATUS")
@NamedQuery(name = "InstructorAppointmentStatus.findAll", query = "SELECT i FROM InstructorAppointmentStatus i")
public class InstructorAppointmentStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPOINTMENT_ID")
    private long appointmentId;

    private String comments;

    @Column(name = "REMINDER_COUNT")
    private BigDecimal reminderCount;

    @Column(name = "SHOW_STATUS")
    private String showStatus;

    private BigDecimal site;

    @Column(name = "STUDENT_NOTE")
    private String studentNote;

    private Object updated;

    @Column(name = "UPDATED_BY")
    private BigDecimal updatedBy;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional one-to-one association to Appointment
    @OneToOne
    @JoinColumn(name = "APPOINTMENT_ID")
    private Appointment appointment;

    public InstructorAppointmentStatus() {}

    public long getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getReminderCount() {
        return this.reminderCount;
    }

    public void setReminderCount(BigDecimal reminderCount) {
        this.reminderCount = reminderCount;
    }

    public String getShowStatus() {
        return this.showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }

    public BigDecimal getSite() {
        return this.site;
    }

    public void setSite(BigDecimal site) {
        this.site = site;
    }

    public String getStudentNote() {
        return this.studentNote;
    }

    public void setStudentNote(String studentNote) {
        this.studentNote = studentNote;
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

    public Appointment getAppointment() {
        return this.appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
