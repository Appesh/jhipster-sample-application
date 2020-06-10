package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the APPOINTMENT_CUSTOMERS database table.
 *
 */
@Embeddable
public class AppointmentCustomerPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "CUSTOMER_ID", insertable = false, updatable = false)
    private long customerId;

    @Column(name = "APPOINTMENT_ID")
    private long appointmentId;

    public AppointmentCustomerPK() {}

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppointmentCustomerPK)) {
            return false;
        }
        AppointmentCustomerPK castOther = (AppointmentCustomerPK) other;
        return (this.customerId == castOther.customerId) && (this.appointmentId == castOther.appointmentId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.customerId ^ (this.customerId >>> 32)));
        hash = hash * prime + ((int) (this.appointmentId ^ (this.appointmentId >>> 32)));

        return hash;
    }
}
