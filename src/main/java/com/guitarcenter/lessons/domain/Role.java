package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the "ROLE" database table.
 *
 */
@Entity
@Table(name = "\"ROLE\"")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private long roleId;

    private String description;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "ROLE_NAME")
    private String roleName;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to PersonRole
    @OneToMany(mappedBy = "role")
    private List<PersonRole> personRoles;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional many-to-one association to UserLog
    @OneToMany(mappedBy = "role")
    private List<UserLog> userLogs;

    public Role() {}

    public long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public List<PersonRole> getPersonRoles() {
        return this.personRoles;
    }

    public void setPersonRoles(List<PersonRole> personRoles) {
        this.personRoles = personRoles;
    }

    public PersonRole addPersonRole(PersonRole personRole) {
        getPersonRoles().add(personRole);
        personRole.setRole(this);

        return personRole;
    }

    public PersonRole removePersonRole(PersonRole personRole) {
        getPersonRoles().remove(personRole);
        personRole.setRole(null);

        return personRole;
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

    public List<UserLog> getUserLogs() {
        return this.userLogs;
    }

    public void setUserLogs(List<UserLog> userLogs) {
        this.userLogs = userLogs;
    }

    public UserLog addUserLog(UserLog userLog) {
        getUserLogs().add(userLog);
        userLog.setRole(this);

        return userLog;
    }

    public UserLog removeUserLog(UserLog userLog) {
        getUserLogs().remove(userLog);
        userLog.setRole(null);

        return userLog;
    }
}
