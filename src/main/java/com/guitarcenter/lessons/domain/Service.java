package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the "SERVICE" database table.
 *
 */
@Entity
@Table(name = "\"SERVICE\"")
@NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SERVICE_ID")
    private long serviceId;

    @Column(name = "ALLOW_BAND_NAME")
    private String allowBandName;

    private String enabled;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "REQUIRES_INSTRUCTOR")
    private String requiresInstructor;

    @Column(name = "SERVICE_NAME")
    private String serviceName;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Activity
    @OneToMany(mappedBy = "service")
    private List<Activity> activities;

    //bi-directional many-to-one association to ProfileLookup
    @OneToMany(mappedBy = "service")
    private List<ProfileLookup> profileLookups;

    //bi-directional many-to-one association to ProfileService
    @OneToMany(mappedBy = "service")
    private List<ProfileService> profileServices;

    //bi-directional many-to-many association to Room
    @ManyToMany
    @JoinTable(
        name = "ROOM_SERVICES",
        joinColumns = { @JoinColumn(name = "SERVICE_ID") },
        inverseJoinColumns = { @JoinColumn(name = "ROOM_ID") }
    )
    private List<Room> rooms;

    //bi-directional many-to-many association to RoomTemplate
    @ManyToMany
    @JoinTable(
        name = "ROOM_TEMPLATE_SERVICES",
        joinColumns = { @JoinColumn(name = "SERVICE_ID") },
        inverseJoinColumns = { @JoinColumn(name = "ROOM_TEMPLATE_ID") }
    )
    private List<RoomTemplate> roomTemplates;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    public Service() {}

    public long getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public String getAllowBandName() {
        return this.allowBandName;
    }

    public void setAllowBandName(String allowBandName) {
        this.allowBandName = allowBandName;
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

    public String getRequiresInstructor() {
        return this.requiresInstructor;
    }

    public void setRequiresInstructor(String requiresInstructor) {
        this.requiresInstructor = requiresInstructor;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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

    public List<Activity> getActivities() {
        return this.activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Activity addActivity(Activity activity) {
        getActivities().add(activity);
        activity.setService(this);

        return activity;
    }

    public Activity removeActivity(Activity activity) {
        getActivities().remove(activity);
        activity.setService(null);

        return activity;
    }

    public List<ProfileLookup> getProfileLookups() {
        return this.profileLookups;
    }

    public void setProfileLookups(List<ProfileLookup> profileLookups) {
        this.profileLookups = profileLookups;
    }

    public ProfileLookup addProfileLookup(ProfileLookup profileLookup) {
        getProfileLookups().add(profileLookup);
        profileLookup.setService(this);

        return profileLookup;
    }

    public ProfileLookup removeProfileLookup(ProfileLookup profileLookup) {
        getProfileLookups().remove(profileLookup);
        profileLookup.setService(null);

        return profileLookup;
    }

    public List<ProfileService> getProfileServices() {
        return this.profileServices;
    }

    public void setProfileServices(List<ProfileService> profileServices) {
        this.profileServices = profileServices;
    }

    public ProfileService addProfileService(ProfileService profileService) {
        getProfileServices().add(profileService);
        profileService.setService(this);

        return profileService;
    }

    public ProfileService removeProfileService(ProfileService profileService) {
        getProfileServices().remove(profileService);
        profileService.setService(null);

        return profileService;
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
}
