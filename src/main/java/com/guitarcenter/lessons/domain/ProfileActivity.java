package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the PROFILE_ACTIVITY database table.
 *
 */
@Entity
@Table(name = "PROFILE_ACTIVITY")
@NamedQuery(name = "ProfileActivity.findAll", query = "SELECT p FROM ProfileActivity p")
public class ProfileActivity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROFILE_ACTIVITY_ID")
    private long profileActivityId;

    private String enabled;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Activity
    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;

    //bi-directional many-to-one association to LocationProfile
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private LocationProfile locationProfile;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    public ProfileActivity() {}

    public long getProfileActivityId() {
        return this.profileActivityId;
    }

    public void setProfileActivityId(long profileActivityId) {
        this.profileActivityId = profileActivityId;
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

    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
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

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
