package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the PROFILE_TIMEOFF database table.
 *
 */
@Entity
@Table(name = "PROFILE_TIMEOFF")
@NamedQuery(name = "ProfileTimeoff.findAll", query = "SELECT p FROM ProfileTimeoff p")
public class ProfileTimeoff implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROFILE_TIMEOFF_ID")
    private long profileTimeoffId;

    @Column(name = "END_TIME")
    private Object endTime;

    @Column(name = "START_TIME")
    private Object startTime;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to LocationProfile
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private LocationProfile locationProfile;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    public ProfileTimeoff() {}

    public long getProfileTimeoffId() {
        return this.profileTimeoffId;
    }

    public void setProfileTimeoffId(long profileTimeoffId) {
        this.profileTimeoffId = profileTimeoffId;
    }

    public Object getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public Object getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Object startTime) {
        this.startTime = startTime;
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

    public LocationProfile getLocationProfile() {
        return this.locationProfile;
    }

    public void setLocationProfile(LocationProfile locationProfile) {
        this.locationProfile = locationProfile;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
