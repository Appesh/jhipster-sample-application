package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the INSTRUCTOR database table.
 *
 */
@Entity
@NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i")
public class Instructor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INSTRUCTOR_ID")
    private long instructorId;

    private String enabled;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "EXTERNAL_SOURCE")
    private String externalSource;

    private String status;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Appointment
    @OneToMany(mappedBy = "instructor")
    private List<Appointment> appointments;

    //bi-directional many-to-one association to Availability
    @ManyToOne
    @JoinColumn(name = "AVAILABILITY_ID")
    private Availability availability;

    //bi-directional many-to-one association to Location
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person1;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person2;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional many-to-many association to Activity
    @ManyToMany
    @JoinTable(
        name = "INSTRUCTOR_ACTIVITIES",
        joinColumns = { @JoinColumn(name = "INSTRUCTOR_ID") },
        inverseJoinColumns = { @JoinColumn(name = "ACTIVITY_ID") }
    )
    private List<Activity> activities;

    //bi-directional many-to-one association to Onetime
    @OneToMany(mappedBy = "instructor")
    private List<Onetime> onetimes;

    //bi-directional many-to-one association to Timeoff
    @OneToMany(mappedBy = "instructor")
    private List<Timeoff> timeoffs;

    public Instructor() {}

    public long getInstructorId() {
        return this.instructorId;
    }

    public void setInstructorId(long instructorId) {
        this.instructorId = instructorId;
    }

    public String getEnabled() {
        return this.enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalSource() {
        return this.externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Appointment addAppointment(Appointment appointment) {
        getAppointments().add(appointment);
        appointment.setInstructor(this);

        return appointment;
    }

    public Appointment removeAppointment(Appointment appointment) {
        getAppointments().remove(appointment);
        appointment.setInstructor(null);

        return appointment;
    }

    public Availability getAvailability() {
        return this.availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person getPerson1() {
        return this.person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return this.person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public List<Activity> getActivities() {
        return this.activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Onetime> getOnetimes() {
        return this.onetimes;
    }

    public void setOnetimes(List<Onetime> onetimes) {
        this.onetimes = onetimes;
    }

    public Onetime addOnetime(Onetime onetime) {
        getOnetimes().add(onetime);
        onetime.setInstructor(this);

        return onetime;
    }

    public Onetime removeOnetime(Onetime onetime) {
        getOnetimes().remove(onetime);
        onetime.setInstructor(null);

        return onetime;
    }

    public List<Timeoff> getTimeoffs() {
        return this.timeoffs;
    }

    public void setTimeoffs(List<Timeoff> timeoffs) {
        this.timeoffs = timeoffs;
    }

    public Timeoff addTimeoff(Timeoff timeoff) {
        getTimeoffs().add(timeoff);
        timeoff.setInstructor(this);

        return timeoff;
    }

    public Timeoff removeTimeoff(Timeoff timeoff) {
        getTimeoffs().remove(timeoff);
        timeoff.setInstructor(null);

        return timeoff;
    }
}
