package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the APPOINTMENT_LOG database table.
 *
 */
@Entity
@Table(name = "APPOINTMENT_LOG")
@NamedQuery(name = "AppointmentLog.findAll", query = "SELECT a FROM AppointmentLog a")
public class AppointmentLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AppointmentLogPK id;

    @Column(name = "ACTIVITY_ID")
    private BigDecimal activityId;

    private String canceled;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "END_TIME")
    private Object endTime;

    @Column(name = "INSTRUCTOR_ID")
    private BigDecimal instructorId;

    private String note;

    @Column(name = "ROOM_ID")
    private BigDecimal roomId;

    @Column(name = "SITE_ID")
    private BigDecimal siteId;

    @Column(name = "START_TIME")
    private Object startTime;

    @Column(name = "UPDATED_BY")
    private BigDecimal updatedBy;

    //bi-directional many-to-one association to Appointment
    @ManyToOne
    @JoinColumn(name = "APPOINTMENT_ID")
    private Appointment appointment;

    public AppointmentLog() {}

    public AppointmentLogPK getId() {
        return this.id;
    }

    public void setId(AppointmentLogPK id) {
        this.id = id;
    }

    public BigDecimal getActivityId() {
        return this.activityId;
    }

    public void setActivityId(BigDecimal activityId) {
        this.activityId = activityId;
    }

    public String getCanceled() {
        return this.canceled;
    }

    public void setCanceled(String canceled) {
        this.canceled = canceled;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Object getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getInstructorId() {
        return this.instructorId;
    }

    public void setInstructorId(BigDecimal instructorId) {
        this.instructorId = instructorId;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getRoomId() {
        return this.roomId;
    }

    public void setRoomId(BigDecimal roomId) {
        this.roomId = roomId;
    }

    public BigDecimal getSiteId() {
        return this.siteId;
    }

    public void setSiteId(BigDecimal siteId) {
        this.siteId = siteId;
    }

    public Object getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Object startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(BigDecimal updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Appointment getAppointment() {
        return this.appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
