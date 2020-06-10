package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the PERSON_ROLE database table.
 *
 */
@Entity
@Table(name = "PERSON_ROLE")
@NamedQuery(name = "PersonRole.findAll", query = "SELECT p FROM PersonRole p")
public class PersonRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ROLE_ID")
    private long personRoleId;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Location
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person1;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person2;

    //bi-directional many-to-one association to Role
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    public PersonRole() {}

    public long getPersonRoleId() {
        return this.personRoleId;
    }

    public void setPersonRoleId(long personRoleId) {
        this.personRoleId = personRoleId;
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

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Person getPerson1() {
        return this.person1;
    }

    public void setPerson1(Person person1) {
        this.person1 = person1;
    }

    public Person getPerson2() {
        return this.person2;
    }

    public void setPerson2(Person person2) {
        this.person2 = person2;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
