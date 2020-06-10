package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the ROOM_TYPE database table.
 *
 */
@Entity
@Table(name = "ROOM_TYPE")
@NamedQuery(name = "RoomType.findAll", query = "SELECT r FROM RoomType r")
public class RoomType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_TYPE_ID")
    private long roomTypeId;

    @Column(name = "CAN_SPLIT_ROOM")
    private String canSplitRoom;

    private String enabled;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "ROOM_TYPE")
    private String roomType;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Room
    @OneToMany(mappedBy = "roomType")
    private List<Room> rooms;

    //bi-directional many-to-one association to RoomSize
    @OneToMany(mappedBy = "roomType")
    private List<RoomSize> roomSizes;

    //bi-directional many-to-one association to RoomTemplate
    @OneToMany(mappedBy = "roomType")
    private List<RoomTemplate> roomTemplates;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    public RoomType() {}

    public long getRoomTypeId() {
        return this.roomTypeId;
    }

    public void setRoomTypeId(long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getCanSplitRoom() {
        return this.canSplitRoom;
    }

    public void setCanSplitRoom(String canSplitRoom) {
        this.canSplitRoom = canSplitRoom;
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

    public String getRoomType() {
        return this.roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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
        room.setRoomType(this);

        return room;
    }

    public Room removeRoom(Room room) {
        getRooms().remove(room);
        room.setRoomType(null);

        return room;
    }

    public List<RoomSize> getRoomSizes() {
        return this.roomSizes;
    }

    public void setRoomSizes(List<RoomSize> roomSizes) {
        this.roomSizes = roomSizes;
    }

    public RoomSize addRoomSize(RoomSize roomSize) {
        getRoomSizes().add(roomSize);
        roomSize.setRoomType(this);

        return roomSize;
    }

    public RoomSize removeRoomSize(RoomSize roomSize) {
        getRoomSizes().remove(roomSize);
        roomSize.setRoomType(null);

        return roomSize;
    }

    public List<RoomTemplate> getRoomTemplates() {
        return this.roomTemplates;
    }

    public void setRoomTemplates(List<RoomTemplate> roomTemplates) {
        this.roomTemplates = roomTemplates;
    }

    public RoomTemplate addRoomTemplate(RoomTemplate roomTemplate) {
        getRoomTemplates().add(roomTemplate);
        roomTemplate.setRoomType(this);

        return roomTemplate;
    }

    public RoomTemplate removeRoomTemplate(RoomTemplate roomTemplate) {
        getRoomTemplates().remove(roomTemplate);
        roomTemplate.setRoomType(null);

        return roomTemplate;
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
