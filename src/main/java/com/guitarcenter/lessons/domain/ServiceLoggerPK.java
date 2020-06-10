package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SERVICE_LOGGER database table.
 *
 */
@Embeddable
public class ServiceLoggerPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "SERVICE_NAME")
    private String serviceName;

    @Column(name = "ACCESS_TIMESTAMP")
    private String accessTimestamp;

    public ServiceLoggerPK() {}

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAccessTimestamp() {
        return this.accessTimestamp;
    }

    public void setAccessTimestamp(String accessTimestamp) {
        this.accessTimestamp = accessTimestamp;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServiceLoggerPK)) {
            return false;
        }
        ServiceLoggerPK castOther = (ServiceLoggerPK) other;
        return this.serviceName.equals(castOther.serviceName) && this.accessTimestamp.equals(castOther.accessTimestamp);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.serviceName.hashCode();
        hash = hash * prime + this.accessTimestamp.hashCode();

        return hash;
    }
}
