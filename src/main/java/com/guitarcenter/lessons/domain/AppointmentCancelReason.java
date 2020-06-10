package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the APPOINTMENT_CANCEL_REASON database table.
 *
 */
@Entity
@Table(name = "APPOINTMENT_CANCEL_REASON")
@NamedQuery(name = "AppointmentCancelReason.findAll", query = "SELECT a FROM AppointmentCancelReason a")
public class AppointmentCancelReason implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPOINTMENT_CANCEL_REASON_ID")
    private long appointmentCancelReasonId;

    @Column(name = "CANCEL_REASON")
    private String cancelReason;

    private String enabled;

    @Column(name = "IS_FOR_RECURRING")
    private String isForRecurring;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-many association to Appointment
    @ManyToMany
    @JoinTable(
        name = "APPOINTMENT_CANCEL",
        joinColumns = { @JoinColumn(name = "APPOINTMENT_CANCEL_REASON_ID") },
        inverseJoinColumns = { @JoinColumn(name = "APPOINTMENT_ID") }
    )
    private List<Appointment> appointments;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    public AppointmentCancelReason() {}

    public long getAppointmentCancelReasonId() {
        return this.appointmentCancelReasonId;
    }

    public void setAppointmentCancelReasonId(long appointmentCancelReasonId) {
        this.appointmentCancelReasonId = appointmentCancelReasonId;
    }

    public String getCancelReason() {
        return this.cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public String getEnabled() {
        return this.enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getIsForRecurring() {
        return this.isForRecurring;
    }

    public void setIsForRecurring(String isForRecurring) {
        this.isForRecurring = isForRecurring;
    }

    public Object getUpdated() {
        return this.updated;
    }

    public void setUpdated(Object updated) {
        this.updated = updated;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
