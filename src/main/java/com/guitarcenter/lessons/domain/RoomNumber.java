package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the ROOM_NUMBER database table.
 *
 */
@Entity
@Table(name = "ROOM_NUMBER")
@NamedQuery(name = "RoomNumber.findAll", query = "SELECT r FROM RoomNumber r")
public class RoomNumber implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROOM_NUMBER_ID")
    private long roomNumberId;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "ROOM_NUMBER")
    private String roomNumber;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Room
    @OneToMany(mappedBy = "roomNumber")
    private List<Room> rooms;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    public RoomNumber() {}

    public long getRoomNumberId() {
        return this.roomNumberId;
    }

    public void setRoomNumberId(long roomNumberId) {
        this.roomNumberId = roomNumberId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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
        room.setRoomNumber(this);

        return room;
    }

    public Room removeRoom(Room room) {
        getRooms().remove(room);
        room.setRoomNumber(null);

        return room;
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
