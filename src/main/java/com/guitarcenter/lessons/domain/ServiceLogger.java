package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SERVICE_LOGGER database table.
 *
 */
@Entity
@Table(name = "SERVICE_LOGGER")
@NamedQuery(name = "ServiceLogger.findAll", query = "SELECT s FROM ServiceLogger s")
public class ServiceLogger implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ServiceLoggerPK id;

    @Column(name = "APPOINTMENT_ID")
    private String appointmentId;

    @Column(name = "APPOINTMENT_SERIES_ID")
    private String appointmentSeriesId;

    @Column(name = "CUSTOMER_MEMBER_ID")
    private String customerMemberId;

    public ServiceLogger() {}

    public ServiceLoggerPK getId() {
        return this.id;
    }

    public void setId(ServiceLoggerPK id) {
        this.id = id;
    }

    public String getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentSeriesId() {
        return this.appointmentSeriesId;
    }

    public void setAppointmentSeriesId(String appointmentSeriesId) {
        this.appointmentSeriesId = appointmentSeriesId;
    }

    public String getCustomerMemberId() {
        return this.customerMemberId;
    }

    public void setCustomerMemberId(String customerMemberId) {
        this.customerMemberId = customerMemberId;
    }
}
