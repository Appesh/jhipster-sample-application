package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the ROOM_TEMPLATE database table.
 *
 */
@Entity
@Table(name = "ROOM_TEMPLATE")
@NamedQuery(name = "RoomTemplate.findAll", query = "SELECT r FROM RoomTemplate r")
public class RoomTemplate implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_TEMPLATE_ID")
    private long roomTemplateId;

    private String enabled;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "IS_SPLIT_ROOM")
    private String isSplitRoom;

    @Column(name = "ROOM_TEMPLATE_NAME")
    private String roomTemplateName;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Room
    @OneToMany(mappedBy = "roomTemplate")
    private List<Room> rooms;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to RoomSize
    @ManyToOne
    @JoinColumn(name = "ROOM_SIZE_ID")
    private RoomSize roomSize;

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
        name = "ROOM_TEMPLATE_ACTIVITIES",
        joinColumns = { @JoinColumn(name = "ROOM_TEMPLATE_ID") },
        inverseJoinColumns = { @JoinColumn(name = "ACTIVITY_ID") }
    )
    private List<Activity> activities;

    //bi-directional many-to-many association to Service
    @ManyToMany(mappedBy = "roomTemplates")
    private List<Service> services;

    public RoomTemplate() {}

    public long getRoomTemplateId() {
        return this.roomTemplateId;
    }

    public void setRoomTemplateId(long roomTemplateId) {
        this.roomTemplateId = roomTemplateId;
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

    public String getRoomTemplateName() {
        return this.roomTemplateName;
    }

    public void setRoomTemplateName(String roomTemplateName) {
        this.roomTemplateName = roomTemplateName;
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

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room addRoom(Room room) {
        getRooms().add(room);
        room.setRoomTemplate(this);

        return room;
    }

    public Room removeRoom(Room room) {
        getRooms().remove(room);
        room.setRoomTemplate(null);

        return room;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public RoomSize getRoomSize() {
        return this.roomSize;
    }

    public void setRoomSize(RoomSize roomSize) {
        this.roomSize = roomSize;
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
