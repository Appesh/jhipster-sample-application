package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the APPOINTMENT_BOOK database table.
 *
 */
@Entity
@Table(name = "APPOINTMENT_BOOK")
@NamedQuery(name = "AppointmentBook.findAll", query = "SELECT a FROM AppointmentBook a")
public class AppointmentBook implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPOINTMENT_ID")
    private long appointmentId;

    @Column(name = "BOOK_FLAG")
    private String bookFlag;

    @Column(name = "EXTERNAL_SOURCE")
    private String externalSource;

    @Column(name = "ORDER_ID")
    private BigDecimal orderId;

    private BigDecimal site;

    private Object updated;

    @Column(name = "UPDATED_BY")
    private BigDecimal updatedBy;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional one-to-one association to Appointment
    @OneToOne
    @JoinColumn(name = "APPOINTMENT_ID")
    private Appointment appointment;

    public AppointmentBook() {}

    public long getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getBookFlag() {
        return this.bookFlag;
    }

    public void setBookFlag(String bookFlag) {
        this.bookFlag = bookFlag;
    }

    public String getExternalSource() {
        return this.externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public BigDecimal getOrderId() {
        return this.orderId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getSite() {
        return this.site;
    }

    public void setSite(BigDecimal site) {
        this.site = site;
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
