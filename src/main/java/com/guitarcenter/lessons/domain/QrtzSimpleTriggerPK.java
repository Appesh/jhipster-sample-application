package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the QRTZ_SIMPLE_TRIGGERS database table.
 *
 */
@Embeddable
public class QrtzSimpleTriggerPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "TRIGGER_NAME", insertable = false, updatable = false)
    private String triggerName;

    @Column(name = "TRIGGER_GROUP", insertable = false, updatable = false)
    private String triggerGroup;

    public QrtzSimpleTriggerPK() {}

    public String getTriggerName() {
        return this.triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return this.triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrtzSimpleTriggerPK)) {
            return false;
        }
        QrtzSimpleTriggerPK castOther = (QrtzSimpleTriggerPK) other;
        return this.triggerName.equals(castOther.triggerName) && this.triggerGroup.equals(castOther.triggerGroup);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.triggerName.hashCode();
        hash = hash * prime + this.triggerGroup.hashCode();

        return hash;
    }
}