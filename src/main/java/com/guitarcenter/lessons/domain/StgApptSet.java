package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the STG_APPT_SET database table.
 *
 */
@Entity
@Table(name = "STG_APPT_SET")
@NamedQuery(name = "StgApptSet.findAll", query = "SELECT s FROM StgApptSet s")
public class StgApptSet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String apptsetid;

    private String apptsetname;

    private String apptsettypeid;

    private String licenseeid;

    public StgApptSet() {}

    public String getApptsetid() {
        return this.apptsetid;
    }

    public void setApptsetid(String apptsetid) {
        this.apptsetid = apptsetid;
    }

    public String getApptsetname() {
        return this.apptsetname;
    }

    public void setApptsetname(String apptsetname) {
        this.apptsetname = apptsetname;
    }

    public String getApptsettypeid() {
        return this.apptsettypeid;
    }

    public void setApptsettypeid(String apptsettypeid) {
        this.apptsettypeid = apptsettypeid;
    }

    public String getLicenseeid() {
        return this.licenseeid;
    }

    public void setLicenseeid(String licenseeid) {
        this.licenseeid = licenseeid;
    }
}
