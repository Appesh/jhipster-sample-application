package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the QRTZ_TRIGGER_LISTENERS database table.
 *
 */
@Embeddable
public class QrtzTriggerListenerPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "TRIGGER_NAME", insertable = false, updatable = false)
    private String triggerName;

    @Column(name = "TRIGGER_GROUP", insertable = false, updatable = false)
    private String triggerGroup;

    @Column(name = "TRIGGER_LISTENER")
    private String triggerListener;

    public QrtzTriggerListenerPK() {}

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

    public String getTriggerListener() {
        return this.triggerListener;
    }

    public void setTriggerListener(String triggerListener) {
        this.triggerListener = triggerListener;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrtzTriggerListenerPK)) {
            return false;
        }
        QrtzTriggerListenerPK castOther = (QrtzTriggerListenerPK) other;
        return (
            this.triggerName.equals(castOther.triggerName) &&
            this.triggerGroup.equals(castOther.triggerGroup) &&
            this.triggerListener.equals(castOther.triggerListener)
        );
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.triggerName.hashCode();
        hash = hash * prime + this.triggerGroup.hashCode();
        hash = hash * prime + this.triggerListener.hashCode();

        return hash;
    }
}
