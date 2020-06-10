package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the QRTZ_JOB_LISTENERS database table.
 *
 */
@Embeddable
public class QrtzJobListenerPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "JOB_NAME", insertable = false, updatable = false)
    private String jobName;

    @Column(name = "JOB_GROUP", insertable = false, updatable = false)
    private String jobGroup;

    @Column(name = "JOB_LISTENER")
    private String jobListener;

    public QrtzJobListenerPK() {}

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return this.jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobListener() {
        return this.jobListener;
    }

    public void setJobListener(String jobListener) {
        this.jobListener = jobListener;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QrtzJobListenerPK)) {
            return false;
        }
        QrtzJobListenerPK castOther = (QrtzJobListenerPK) other;
        return (
            this.jobName.equals(castOther.jobName) &&
            this.jobGroup.equals(castOther.jobGroup) &&
            this.jobListener.equals(castOther.jobListener)
        );
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.jobName.hashCode();
        hash = hash * prime + this.jobGroup.hashCode();
        hash = hash * prime + this.jobListener.hashCode();

        return hash;
    }
}
