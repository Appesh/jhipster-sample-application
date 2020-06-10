package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the ROOM database table.
 *
 */
@Entity
@NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_ID")
    private long roomId;

    private String enabled;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "IS_SPLIT_ROOM")
    private String isSplitRoom;

    @Column(name = "PROFILE_ROOM_NAME")
    private String profileRoomName;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Appointment
    @OneToMany(mappedBy = "room")
    private List<Appointment> appointments;

    //bi-directional many-to-one association to LocationProfile
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private LocationProfile locationProfile;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Room
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Room room;

    //bi-directional many-to-one association to Room
    @OneToMany(mappedBy = "room")
    private List<Room> rooms;

    //bi-directional many-to-one association to RoomNumber
    @ManyToOne
    @JoinColumn(name = "ROOM_NUMBER_ID")
    private RoomNumber roomNumber;

    //bi-directional many-to-one association to RoomSize
    @ManyToOne
    @JoinColumn(name = "ROOM_SIZE_ID")
    private RoomSize roomSize;

    //bi-directional many-to-one association to RoomTemplate
    @ManyToOne
    @JoinColumn(name = "ROOM_TEMPLATE_ID")
    private RoomTemplate roomTemplate;

    //bi-directional many-to-one association to RoomType
    @ManyToOne
    @JoinColumn(name = "ROOM_TYPE_ID")
    private RoomType roomType;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional many-to-many association to Activity
    @ManyToMany
    @JoinTable(
        name = "ROOM_ACTIVITIES",
        joinColumns = { @JoinColumn(name = "ROOM_ID") },
        inverseJoinColumns = { @JoinColumn(name = "ACTIVITY_ID") }
    )
    private List<Activity> activities;

    //bi-directional many-to-many association to Service
    @ManyToMany(mappedBy = "rooms")
    private List<Service> services;

    public Room() {}

    public long getRoomId() {
        return this.roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
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

    public String getIsSplitRoom() {
        return this.isSplitRoom;
    }

    public void setIsSplitRoom(String isSplitRoom) {
        this.isSplitRoom = isSplitRoom;
    }

    public String getProfileRoomName() {
        return this.profileRoomName;
    }

    public void setProfileRoomName(String profileRoomName) {
        this.profileRoomName = profileRoomName;
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
        appointment.setRoom(this);

        return appointment;
    }

    public Appointment removeAppointment(Appointment appointment) {
        getAppointments().remove(appointment);
        appointment.setRoom(null);

        return appointment;
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

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room addRoom(Room room) {
        getRooms().add(room);
        room.setRoom(this);

        return room;
    }

    public Room removeRoom(Room room) {
        getRooms().remove(room);
        room.setRoom(null);

        return room;
    }

    public RoomNumber getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(RoomNumber roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomSize getRoomSize() {
        return this.roomSize;
    }

    public void setRoomSize(RoomSize roomSize) {
        this.roomSize = roomSize;
    }

    public RoomTemplate getRoomTemplate() {
        return this.roomTemplate;
    }

    public void setRoomTemplate(RoomTemplate roomTemplate) {
        this.roomTemplate = roomTemplate;
    }

    public RoomType getRoomType() {
        return this.roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
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

    public List<Service> getServices() {
        return this.services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
