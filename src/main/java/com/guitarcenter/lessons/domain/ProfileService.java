package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the PROFILE_SERVICE database table.
 *
 */
@Entity
@Table(name = "PROFILE_SERVICE")
@NamedQuery(name = "ProfileService.findAll", query = "SELECT p FROM ProfileService p")
public class ProfileService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROFILE_SERVICE_ID")
    private long profileServiceId;

    private String enabled;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to LocationProfile
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private LocationProfile locationProfile;

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

    public ProfileService() {}

    public long getProfileServiceId() {
        return this.profileServiceId;
    }

    public void setProfileServiceId(long profileServiceId) {
        this.profileServiceId = profileServiceId;
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
}
