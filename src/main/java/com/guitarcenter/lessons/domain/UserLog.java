package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the USER_LOG database table.
 *
 */
@Entity
@Table(name = "USER_LOG")
@NamedQuery(name = "UserLog.findAll", query = "SELECT u FROM UserLog u")
public class UserLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserLogPK id;

    @Column(name = "LOCATION_EXTERNAL_ID")
    private String locationExternalId;

    @Column(name = "LOGIN_TIMESTAMP")
    private Object loginTimestamp;

    @Column(name = "LOGOUT_TIMESTAMP")
    private Object logoutTimestamp;

    @Column(name = "USER_LOG_ID")
    private BigDecimal userLogId;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    //bi-directional many-to-one association to Role
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    public UserLog() {}

    public UserLogPK getId() {
        return this.id;
    }

    public void setId(UserLogPK id) {
        this.id = id;
    }

    public String getLocationExternalId() {
        return this.locationExternalId;
    }

    public void setLocationExternalId(String locationExternalId) {
        this.locationExternalId = locationExternalId;
    }

    public Object getLoginTimestamp() {
        return this.loginTimestamp;
    }

    public void setLoginTimestamp(Object loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    public Object getLogoutTimestamp() {
        return this.logoutTimestamp;
    }

    public void setLogoutTimestamp(Object logoutTimestamp) {
        this.logoutTimestamp = logoutTimestamp;
    }

    public BigDecimal getUserLogId() {
        return this.userLogId;
    }

    public void setUserLogId(BigDecimal userLogId) {
        this.userLogId = userLogId;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
