package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the EMPLOYEE_LOCATION_BACKUP database table.
 *
 */
@Entity
@Table(name = "EMPLOYEE_LOCATION_BACKUP")
@NamedQuery(name = "EmployeeLocationBackup.findAll", query = "SELECT e FROM EmployeeLocationBackup e")
public class EmployeeLocationBackup implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "EMPLOYEE_ID")
    private BigDecimal employeeId;

    @Column(name = "ENTERPRISE_STATUS")
    private String enterpriseStatus;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "EXTERNAL_SOURCE")
    private String externalSource;

    @Column(name = "LOCATION_ID")
    private BigDecimal locationId;

    @Column(name = "PERSON_ID")
    private BigDecimal personId;

    @Column(name = "SITE_ID")
    private BigDecimal siteId;

    private String status;

    private Object updated;

    @Column(name = "UPDATED_BY")
    private BigDecimal updatedBy;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    public EmployeeLocationBackup() {}

    public BigDecimal getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(BigDecimal employeeId) {
        this.employeeId = employeeId;
    }

    public String getEnterpriseStatus() {
        return this.enterpriseStatus;
    }

    public void setEnterpriseStatus(String enterpriseStatus) {
        this.enterpriseStatus = enterpriseStatus;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalSource() {
        return this.externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public BigDecimal getLocationId() {
        return this.locationId;
    }

    public void setLocationId(BigDecimal locationId) {
        this.locationId = locationId;
    }

    public BigDecimal getPersonId() {
        return this.personId;
    }

    public void setPersonId(BigDecimal personId) {
        this.personId = personId;
    }

    public BigDecimal getSiteId() {
        return this.siteId;
    }

    public void setSiteId(BigDecimal siteId) {
        this.siteId = siteId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getUpdated() {
        return this.updated;
    }

    public void setUpdated(Object updated) {
        this.updated = updated;
    }

    public BigDecimal getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(BigDecimal updatedBy) {
        this.updatedBy = updatedBy;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }
}
