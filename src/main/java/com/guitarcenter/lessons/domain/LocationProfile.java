package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the LOCATION_PROFILE database table.
 *
 */
@Entity
@Table(name = "LOCATION_PROFILE")
@NamedQuery(name = "LocationProfile.findAll", query = "SELECT l FROM LocationProfile l")
public class LocationProfile implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROFILE_ID")
    private long profileId;

    private String enabled;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    private String tz;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Appointment
    @OneToMany(mappedBy = "locationProfile")
    private List<Appointment> appointments;

    //bi-directional many-to-one association to AppointmentSery
    @OneToMany(mappedBy = "locationProfile")
    private List<AppointmentSery> appointmentSeries;

    //bi-directional many-to-one association to Location
    @OneToMany(mappedBy = "locationProfile")
    private List<Location> locations;

    //bi-directional many-to-one association to Availability
    @ManyToOne
    @JoinColumn(name = "AVAILABILITY_ID")
    private Availability availability;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional many-to-one association to ProfileActivity
    @OneToMany(mappedBy = "locationProfile")
    private List<ProfileActivity> profileActivities;

    //bi-directional many-to-one association to ProfileService
    @OneToMany(mappedBy = "locationProfile")
    private List<ProfileService> profileServices;

    //bi-directional many-to-one association to ProfileTimeoff
    @OneToMany(mappedBy = "locationProfile")
    private List<ProfileTimeoff> profileTimeoffs;

    //bi-directional many-to-one association to Room
    @OneToMany(mappedBy = "locationProfile")
    private List<Room> rooms;

    public LocationProfile() {}

    public long getProfileId() {
        return this.profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
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

    public String getTz() {
        return this.tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
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
        appointment.setLocationProfile(this);

        return appointment;
    }

    public Appointment removeAppointment(Appointment appointment) {
        getAppointments().remove(appointment);
        appointment.setLocationProfile(null);

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
        appointmentSery.setLocationProfile(this);

        return appointmentSery;
    }

    public AppointmentSery removeAppointmentSery(AppointmentSery appointmentSery) {
        getAppointmentSeries().remove(appointmentSery);
        appointmentSery.setLocationProfile(null);

        return appointmentSery;
    }

    public List<Location> getLocations() {
        return this.locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Location addLocation(Location location) {
        getLocations().add(location);
        location.setLocationProfile(this);

        return location;
    }

    public Location removeLocation(Location location) {
        getLocations().remove(location);
        location.setLocationProfile(null);

        return location;
    }

    public Availability getAvailability() {
        return this.availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
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

    public List<ProfileActivity> getProfileActivities() {
        return this.profileActivities;
    }

    public void setProfileActivities(List<ProfileActivity> profileActivities) {
        this.profileActivities = profileActivities;
    }

    public ProfileActivity addProfileActivity(ProfileActivity profileActivity) {
        getProfileActivities().add(profileActivity);
        profileActivity.setLocationProfile(this);

        return profileActivity;
    }

    public ProfileActivity removeProfileActivity(ProfileActivity profileActivity) {
        getProfileActivities().remove(profileActivity);
        profileActivity.setLocationProfile(null);

        return profileActivity;
    }

    public List<ProfileService> getProfileServices() {
        return this.profileServices;
    }

    public void setProfileServices(List<ProfileService> profileServices) {
        this.profileServices = profileServices;
    }

    public ProfileService addProfileService(ProfileService profileService) {
        getProfileServices().add(profileService);
        profileService.setLocationProfile(this);

        return profileService;
    }

    public ProfileService removeProfileService(ProfileService profileService) {
        getProfileServices().remove(profileService);
        profileService.setLocationProfile(null);

        return profileService;
    }

    public List<ProfileTimeoff> getProfileTimeoffs() {
        return this.profileTimeoffs;
    }

    public void setProfileTimeoffs(List<ProfileTimeoff> profileTimeoffs) {
        this.profileTimeoffs = profileTimeoffs;
    }

    public ProfileTimeoff addProfileTimeoff(ProfileTimeoff profileTimeoff) {
        getProfileTimeoffs().add(profileTimeoff);
        profileTimeoff.setLocationProfile(this);

        return profileTimeoff;
    }

    public ProfileTimeoff removeProfileTimeoff(ProfileTimeoff profileTimeoff) {
        getProfileTimeoffs().remove(profileTimeoff);
        profileTimeoff.setLocationProfile(null);

        return profileTimeoff;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room addRoom(Room room) {
        getRooms().add(room);
        room.setLocationProfile(this);

        return room;
    }

    public Room removeRoom(Room room) {
        getRooms().remove(room);
        room.setLocationProfile(null);

        return room;
    }
}
