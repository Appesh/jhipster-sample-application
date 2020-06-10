package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the AVAILABILITY database table.
 *
 */
@Entity
@NamedQuery(name = "Availability.findAll", query = "SELECT a FROM Availability a")
public class Availability implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AVAILABILITY_ID")
    private long availabilityId;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

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

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    @Column(name = "WEDNESDAY_END_TIME")
    private Object wednesdayEndTime;

    @Column(name = "WEDNESDAY_START_TIME")
    private Object wednesdayStartTime;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional many-to-one association to Instructor
    @OneToMany(mappedBy = "availability")
    private List<Instructor> instructors;

    //bi-directional many-to-one association to LocationProfile
    @OneToMany(mappedBy = "availability")
    private List<LocationProfile> locationProfiles;

    public Availability() {}

    public long getAvailabilityId() {
        return this.availabilityId;
    }

    public void setAvailabilityId(long availabilityId) {
        this.availabilityId = availabilityId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
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

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public List<Instructor> getInstructors() {
        return this.instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Instructor addInstructor(Instructor instructor) {
        getInstructors().add(instructor);
        instructor.setAvailability(this);

        return instructor;
    }

    public Instructor removeInstructor(Instructor instructor) {
        getInstructors().remove(instructor);
        instructor.setAvailability(null);

        return instructor;
    }

    public List<LocationProfile> getLocationProfiles() {
        return this.locationProfiles;
    }

    public void setLocationProfiles(List<LocationProfile> locationProfiles) {
        this.locationProfiles = locationProfiles;
    }

    public LocationProfile addLocationProfile(LocationProfile locationProfile) {
        getLocationProfiles().add(locationProfile);
        locationProfile.setAvailability(this);

        return locationProfile;
    }

    public LocationProfile removeLocationProfile(LocationProfile locationProfile) {
        getLocationProfiles().remove(locationProfile);
        locationProfile.setAvailability(null);

        return locationProfile;
    }
}
