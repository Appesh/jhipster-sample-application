package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the STG_ACTIVITY_MAP database table.
 *
 */
@Entity
@Table(name = "STG_ACTIVITY_MAP")
@NamedQuery(name = "StgActivityMap.findAll", query = "SELECT s FROM StgActivityMap s")
public class StgActivityMap implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ACTIVITY_ID_SRC")
    private String activityIdSrc;

    @Column(name = "ACTIVITY_ID_TARGET")
    private String activityIdTarget;

    @Column(name = "ACTIVITY_NAME_SRC")
    private String activityNameSrc;

    @Column(name = "ACTIVITY_NAME_TARGET")
    private String activityNameTarget;

    public StgActivityMap() {}

    public String getActivityIdSrc() {
        return this.activityIdSrc;
    }

    public void setActivityIdSrc(String activityIdSrc) {
        this.activityIdSrc = activityIdSrc;
    }

    public String getActivityIdTarget() {
        return this.activityIdTarget;
    }

    public void setActivityIdTarget(String activityIdTarget) {
        this.activityIdTarget = activityIdTarget;
    }

    public String getActivityNameSrc() {
        return this.activityNameSrc;
    }

    public void setActivityNameSrc(String activityNameSrc) {
        this.activityNameSrc = activityNameSrc;
    }

    public String getActivityNameTarget() {
        return this.activityNameTarget;
    }

    public void setActivityNameTarget(String activityNameTarget) {
        this.activityNameTarget = activityNameTarget;
    }
}
