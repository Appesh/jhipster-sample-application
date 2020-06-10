package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the USER_LOG database table.
 *
 */
@Embeddable
public class UserLogPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "PERSON_ID", insertable = false, updatable = false)
    private long personId;

    private String updated;

    public UserLogPK() {}

    public long getPersonId() {
        return this.personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
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
        if (!(other instanceof UserLogPK)) {
            return false;
        }
        UserLogPK castOther = (UserLogPK) other;
        return (this.personId == castOther.personId) && this.updated.equals(castOther.updated);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + ((int) (this.personId ^ (this.personId >>> 32)));
        hash = hash * prime + this.updated.hashCode();

        return hash;
    }
}
