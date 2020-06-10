package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the PROFILE_LOOKUP database table.
 *
 */
@Entity
@Table(name = "PROFILE_LOOKUP")
@NamedQuery(name = "ProfileLookup.findAll", query = "SELECT p FROM ProfileLookup p")
public class ProfileLookup implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACTIVITY_ID")
    private long activityId;

    @Column(name = "FRIDAY_END_TIME")
    private Object fridayEndTime;

    @Column(name = "FRIDAY_START_TIME")
    private Object fridayStartTime;

    @Column(name = "MONDAY_END_TIME")
    private Object mondayEndTime;

    @Column(name = "MONDAY_START_TIME")
    private Object mondayStartTime;

    @Column(name = "SATURDAY_END_TIME")
    private Object saturdayEndTime;

    @Column(name = "SATURDAY_START_TIME")
    private Object saturdayStartTime;

    @Column(name = "SITE_ID")
    private BigDecimal siteId;

    @Column(name = "SUNDAY_END_TIME")
    private Object sundayEndTime;

    @Column(name = "SUNDAY_START_TIME")
    private Object sundayStartTime;

    @Column(name = "THURSDAY_END_TIME")
    private Object thursdayEndTime;

    @Column(name = "THURSDAY_START_TIME")
    private Object thursdayStartTime;

    @Column(name = "TUESDAY_END_TIME")
    private Object tuesdayEndTime;

    @Column(name = "TUESDAY_START_TIME")
    private Object tuesdayStartTime;

    private Object updated;

    @Column(name = "UPDATED_BY")
    private BigDecimal updatedBy;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    @Column(name = "WEDNESDAY_END_TIME")
    private Object wednesdayEndTime;

    @Column(name = "WEDNESDAY_START_TIME")
    private Object wednesdayStartTime;

    //bi-directional one-to-one association to Activity
    @OneToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;

    //bi-directional many-to-one association to Service
    @ManyToOne
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    public ProfileLookup() {}

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public Object getFridayEndTime() {
        return this.fridayEndTime;
    }

    public void setFridayEndTime(Object fridayEndTime) {
        this.fridayEndTime = fridayEndTime;
    }

    public Object getFridayStartTime() {
        return this.fridayStartTime;
    }

    public void setFridayStartTime(Object fridayStartTime) {
        this.fridayStartTime = fridayStartTime;
    }

    public Object getMondayEndTime() {
        return this.mondayEndTime;
    }

    public void setMondayEndTime(Object mondayEndTime) {
        this.mondayEndTime = mondayEndTime;
    }

    public Object getMondayStartTime() {
        return this.mondayStartTime;
    }

    public void setMondayStartTime(Object mondayStartTime) {
        this.mondayStartTime = mondayStartTime;
    }

    public Object getSaturdayEndTime() {
        return this.saturdayEndTime;
    }

    public void setSaturdayEndTime(Object saturdayEndTime) {
        this.saturdayEndTime = saturdayEndTime;
    }

    public Object getSaturdayStartTime() {
        return this.saturdayStartTime;
    }

    public void setSaturdayStartTime(Object saturdayStartTime) {
        this.saturdayStartTime = saturdayStartTime;
    }

    public BigDecimal getSiteId() {
        return this.siteId;
    }

    public void setSiteId(BigDecimal siteId) {
        this.siteId = siteId;
    }

    public Object getSundayEndTime() {
        return this.sundayEndTime;
    }

    public void setSundayEndTime(Object sundayEndTime) {
        this.sundayEndTime = sundayEndTime;
    }

    public Object getSundayStartTime() {
        return this.sundayStartTime;
    }

    public void setSundayStartTime(Object sundayStartTime) {
        this.sundayStartTime = sundayStartTime;
    }

    public Object getThursdayEndTime() {
        return this.thursdayEndTime;
    }

    public void setThursdayEndTime(Object thursdayEndTime) {
        this.thursdayEndTime = thursdayEndTime;
    }

    public Object getThursdayStartTime() {
        return this.thursdayStartTime;
    }

    public void setThursdayStartTime(Object thursdayStartTime) {
        this.thursdayStartTime = thursdayStartTime;
    }

    public Object getTuesdayEndTime() {
        return this.tuesdayEndTime;
    }

    public void setTuesdayEndTime(Object tuesdayEndTime) {
        this.tuesdayEndTime = tuesdayEndTime;
    }

    public Object getTuesdayStartTime() {
        return this.tuesdayStartTime;
    }

    public void setTuesdayStartTime(Object tuesdayStartTime) {
        this.tuesdayStartTime = tuesdayStartTime;
    }

    public Object getUpdated() {
        return this.updated;
    }

    public void setUpdated(Object updated) {
        this.updated = updated;
    }

    public BigDecimal getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(BigDecimal updatedBy) {
        this.updatedBy = updatedBy;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public Object getWednesdayEndTime() {
        return this.wednesdayEndTime;
    }

    public void setWednesdayEndTime(Object wednesdayEndTime) {
        this.wednesdayEndTime = wednesdayEndTime;
    }

    public Object getWednesdayStartTime() {
        return this.wednesdayStartTime;
    }

    public void setWednesdayStartTime(Object wednesdayStartTime) {
        this.wednesdayStartTime = wednesdayStartTime;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
