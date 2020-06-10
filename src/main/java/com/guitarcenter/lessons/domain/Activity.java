package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the ACTIVITY database table.
 *
 */
@Entity
@NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACTIVITY_ID")
    private long activityId;

    @Column(name = "ACTIVITY_NAME")
    private String activityName;

    private String enabled;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "MAXIMUM_ATTENDEES")
    private BigDecimal maximumAttendees;

    @Column(name = "MAXIMUM_DURATION")
    private BigDecimal maximumDuration;

    @Column(name = "MINIMUM_ATTENDEES")
    private BigDecimal minimumAttendees;

    @Column(name = "MINIMUM_DURATION")
    private BigDecimal minimumDuration;

    @Column(name = "REQUIRES_INSTRUCTOR")
    private String requiresInstructor;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Service
    @ManyToOne
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional many-to-one association to Appointment
    @OneToMany(mappedBy = "activity")
    private List<Appointment> appointments;

    //bi-directional many-to-one association to AppointmentSery
    @OneToMany(mappedBy = "activity")
    private List<AppointmentSery> appointmentSeries;

    //bi-directional many-to-many association to Instructor
    @ManyToMany(mappedBy = "activities")
    private List<Instructor> instructors;

    //bi-directional many-to-one association to ProfileActivity
    @OneToMany(mappedBy = "activity")
    private List<ProfileActivity> profileActivities;

    //bi-directional one-to-one association to ProfileLookup
    @OneToOne(mappedBy = "activity")
    private ProfileLookup profileLookup;

    //bi-directional many-to-many association to Room
    @ManyToMany(mappedBy = "activities")
    private List<Room> rooms;

    //bi-directional many-to-many association to RoomTemplate
    @ManyToMany(mappedBy = "activities")
    private List<RoomTemplate> roomTemplates;

    public Activity() {}

    public long getActivityId() {
        return this.activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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

    public BigDecimal getMaximumAttendees() {
        return this.maximumAttendees;
    }

    public void setMaximumAttendees(BigDecimal maximumAttendees) {
        this.maximumAttendees = maximumAttendees;
    }

    public BigDecimal getMaximumDuration() {
        return this.maximumDuration;
    }

    public void setMaximumDuration(BigDecimal maximumDuration) {
        this.maximumDuration = maximumDuration;
    }

    public BigDecimal getMinimumAttendees() {
        return this.minimumAttendees;
    }

    public void setMinimumAttendees(BigDecimal minimumAttendees) {
        this.minimumAttendees = minimumAttendees;
    }

    public BigDecimal getMinimumDuration() {
        return this.minimumDuration;
    }

    public void setMinimumDuration(BigDecimal minimumDuration) {
        this.minimumDuration = minimumDuration;
    }

    public String getRequiresInstructor() {
        return this.requiresInstructor;
    }

    public void setRequiresInstructor(String requiresInstructor) {
        this.requiresInstructor = requiresInstructor;
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

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Appointment addAppointment(Appointment appointment) {
        getAppointments().add(appointment);
        appointment.setActivity(this);

        return appointment;
    }

    public Appointment removeAppointment(Appointment appointment) {
        getAppointments().remove(appointment);
        appointment.setActivity(null);

        return appointment;
    }

    public List<AppointmentSery> getAppointmentSeries() {
        return this.appointmentSeries;
    }

    public void setAppointmentSeries(List<AppointmentSery> appointmentSeries) {
        this.appointmentSeries = appointmentSeries;
    }

    public AppointmentSery addAppointmentSery(AppointmentSery appointmentSery) {
        getAppointmentSeries().add(appointmentSery);
        appointmentSery.setActivity(this);

        return appointmentSery;
    }

    public AppointmentSery removeAppointmentSery(AppointmentSery appointmentSery) {
        getAppointmentSeries().remove(appointmentSery);
        appointmentSery.setActivity(null);

        return appointmentSery;
    }

    public List<Instructor> getInstructors() {
        return this.instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<ProfileActivity> getProfileActivities() {
        return this.profileActivities;
    }

    public void setProfileActivities(List<ProfileActivity> profileActivities) {
        this.profileActivities = profileActivities;
    }

    public ProfileActivity addProfileActivity(ProfileActivity profileActivity) {
        getProfileActivities().add(profileActivity);
        profileActivity.setActivity(this);

        return profileActivity;
    }

    public ProfileActivity removeProfileActivity(ProfileActivity profileActivity) {
        getProfileActivities().remove(profileActivity);
        profileActivity.setActivity(null);

        return profileActivity;
    }

    public ProfileLookup getProfileLookup() {
        return this.profileLookup;
    }

    public void setProfileLookup(ProfileLookup profileLookup) {
        this.profileLookup = profileLookup;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<RoomTemplate> getRoomTemplates() {
        return this.roomTemplates;
    }

    public void setRoomTemplates(List<RoomTemplate> roomTemplates) {
        this.roomTemplates = roomTemplates;
    }
}
