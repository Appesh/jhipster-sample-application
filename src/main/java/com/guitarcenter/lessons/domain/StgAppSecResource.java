package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the STG_APP_SEC_RESOURCES database table.
 *
 */
@Entity
@Table(name = "STG_APP_SEC_RESOURCES")
@NamedQuery(name = "StgAppSecResource.findAll", query = "SELECT s FROM StgAppSecResource s")
public class StgAppSecResource implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal applycancellationfee;

    private String appointmentendtime;

    private BigDecimal appointmentid;

    private BigDecimal attendees;

    private String campaigntimezone;

    private BigDecimal cancellationfee;

    private BigDecimal licenseeid;

    private BigDecimal locationid;

    private BigDecimal price;

    private BigDecimal recoverytime;

    private String resourceexternalid;

    private BigDecimal resourceid;

    private String resourcename;

    private BigDecimal resourcepoolid;

    private String resourcepoolname;

    public StgAppSecResource() {}

    public BigDecimal getApplycancellationfee() {
        return this.applycancellationfee;
    }

    public void setApplycancellationfee(BigDecimal applycancellationfee) {
        this.applycancellationfee = applycancellationfee;
    }

    public String getAppointmentendtime() {
        return this.appointmentendtime;
    }

    public void setAppointmentendtime(String appointmentendtime) {
        this.appointmentendtime = appointmentendtime;
    }

    public BigDecimal getAppointmentid() {
        return this.appointmentid;
    }

    public void setAppointmentid(BigDecimal appointmentid) {
        this.appointmentid = appointmentid;
    }

    public BigDecimal getAttendees() {
        return this.attendees;
    }

    public void setAttendees(BigDecimal attendees) {
        this.attendees = attendees;
    }

    public String getCampaigntimezone() {
        return this.campaigntimezone;
    }

    public void setCampaigntimezone(String campaigntimezone) {
        this.campaigntimezone = campaigntimezone;
    }

    public BigDecimal getCancellationfee() {
        return this.cancellationfee;
    }

    public void setCancellationfee(BigDecimal cancellationfee) {
        this.cancellationfee = cancellationfee;
    }

    public BigDecimal getLicenseeid() {
        return this.licenseeid;
    }

    public void setLicenseeid(BigDecimal licenseeid) {
        this.licenseeid = licenseeid;
    }

    public BigDecimal getLocationid() {
        return this.locationid;
    }

    public void setLocationid(BigDecimal locationid) {
        this.locationid = locationid;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRecoverytime() {
        return this.recoverytime;
    }

    public void setRecoverytime(BigDecimal recoverytime) {
        this.recoverytime = recoverytime;
    }

    public String getResourceexternalid() {
        return this.resourceexternalid;
    }

    public void setResourceexternalid(String resourceexternalid) {
        this.resourceexternalid = resourceexternalid;
    }

    public BigDecimal getResourceid() {
        return this.resourceid;
    }

    public void setResourceid(BigDecimal resourceid) {
        this.resourceid = resourceid;
    }

    public String getResourcename() {
        return this.resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public BigDecimal getResourcepoolid() {
        return this.resourcepoolid;
    }

    public void setResourcepoolid(BigDecimal resourcepoolid) {
        this.resourcepoolid = resourcepoolid;
    }

    public String getResourcepoolname() {
        return this.resourcepoolname;
    }

    public void setResourcepoolname(String resourcepoolname) {
        this.resourcepoolname = resourcepoolname;
    }
}
