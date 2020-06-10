package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LOCATION_DST_REG database table.
 *
 */
@Entity
@Table(name = "LOCATION_DST_REG")
@NamedQuery(name = "LocationDstReg.findAll", query = "SELECT l FROM LocationDstReg l")
public class LocationDstReg implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCATION_ID")
    private long locationId;

    @Column(name = "LOCATION_DST_DESC")
    private String locationDstDesc;

    @Column(name = "LOCATION_REG_DESC")
    private String locationRegDesc;

    //bi-directional one-to-one association to Location
    @OneToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    public LocationDstReg() {}

    public long getLocationId() {
        return this.locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getLocationDstDesc() {
        return this.locationDstDesc;
    }

    public void setLocationDstDesc(String locationDstDesc) {
        this.locationDstDesc = locationDstDesc;
    }

    public String getLocationRegDesc() {
        return this.locationRegDesc;
    }

    public void setLocationRegDesc(String locationRegDesc) {
        this.locationRegDesc = locationRegDesc;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
