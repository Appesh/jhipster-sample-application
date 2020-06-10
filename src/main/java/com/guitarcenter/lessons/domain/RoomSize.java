package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the ROOM_SIZE database table.
 *
 */
@Entity
@Table(name = "ROOM_SIZE")
@NamedQuery(name = "RoomSize.findAll", query = "SELECT r FROM RoomSize r")
public class RoomSize implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_SIZE_ID")
    private long roomSizeId;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "ROOM_SIZE_NAME")
    private String roomSizeName;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Room
    @OneToMany(mappedBy = "roomSize")
    private List<Room> rooms;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to RoomType
    @ManyToOne
    @JoinColumn(name = "ROOM_TYPE_ID")
    private RoomType roomType;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional many-to-one association to RoomTemplate
    @OneToMany(mappedBy = "roomSize")
    private List<RoomTemplate> roomTemplates;

    public RoomSize() {}

    public long getRoomSizeId() {
        return this.roomSizeId;
    }

    public void setRoomSizeId(long roomSizeId) {
        this.roomSizeId = roomSizeId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getRoomSizeName() {
        return this.roomSizeName;
    }

    public void setRoomSizeName(String roomSizeName) {
        this.roomSizeName = roomSizeName;
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
        room.setRoomSize(this);

        return room;
    }

    public Room removeRoom(Room room) {
        getRooms().remove(room);
        room.setRoomSize(null);

        return room;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public List<RoomTemplate> getRoomTemplates() {
        return this.roomTemplates;
    }

    public void setRoomTemplates(List<RoomTemplate> roomTemplates) {
        this.roomTemplates = roomTemplates;
    }

    public RoomTemplate addRoomTemplate(RoomTemplate roomTemplate) {
        getRoomTemplates().add(roomTemplate);
        roomTemplate.setRoomSize(this);

        return roomTemplate;
    }

    public RoomTemplate removeRoomTemplate(RoomTemplate roomTemplate) {
        getRoomTemplates().remove(roomTemplate);
        roomTemplate.setRoomSize(null);

        return roomTemplate;
    }
}
