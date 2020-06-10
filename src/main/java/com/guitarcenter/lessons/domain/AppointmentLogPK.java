package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the APPOINTMENT_LOG database table.
 *
 */
@Embeddable
public class AppointmentLogPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "APPOINTMENT_ID", insertable = false, updatable = false)
    private long appointmentId;

    private String updated;

    public AppointmentLogPK() {}

    public long getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getUpdated() {
        return this.updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppointmentLogPK)) {
            return false;
        }
        AppointmentLogPK castOther = (AppointmentLogPK) other;
        return (this.appointmentId == castOther.appointmentId) && this.updated.equals(castOther.updated);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.appointmentId ^ (this.appointmentId >>> 32)));
        hash = hash * prime + this.updated.hashCode();

        return hash;
    }
}
