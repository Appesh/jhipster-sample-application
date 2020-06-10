package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the STG_APPOINTMENTS database table.
 *
 */
@Entity
@Table(name = "STG_APPOINTMENTS")
@NamedQuery(name = "StgAppointment.findAll", query = "SELECT s FROM StgAppointment s")
public class StgAppointment implements Serializable {
    private static final long serialVersionUID = 1L;

    private String activitycancellationfee;

    private String activityexternalid;

    private String activityid;

    private String activityname;

    private String applyactivitycancellationfee;

    private String applyprcancellationfee;

    private String appointmentdurationlabel;

    private String appointmentend;

    private String appointmentexternalid;

    private String appointmentid;

    private String appointmentstart;

    private String apptgroupid;

    private String apptsetid;

    private String attendees;

    private String campaignid;

    private String campaignname;

    private String campaigntimezone;

    private String cancellationtype;

    private String cancellationtypeid;

    private String cancelledbyfirstname;

    private String cancelledbylastname;

    private String cancelledbyuserexternalid;

    private String cancelledbyuserid;

    private String cancelleddate;

    private String clienttimezone;

    private String closeouttime;

    private String completedworkflowsteps;

    private String confirmationnumber;

    private String createdbyuserexternalid;

    private String createdbyuserfirstname;

    private String createdbyuserid;

    private String createdbyuserlastname;

    private String creationdate;

    @Column(name = "D_APPOINTMENTMULTILOCATIONID")
    private String dAppointmentmultilocationid;

    @Column(name = "D_ISMULTILOCATIONHOST_D")
    private String dIsmultilocationhostD;

    private String duration;

    private String initialappointmentid;

    private String initialduration;

    private String iscancelled;

    private String ischeckedin;

    private String ischeckedout;

    private String isconfirmed;

    private String islatecanceled;

    private String isworkflowcompleted;

    private String isworkflowenabled;

    private String licenseeid;

    private String locationid;

    private String locationname;

    private String paymenttypeid;

    private String paymenttypename;

    private String prcancellationfee;

    private String price;

    private String primaryresourceprice;

    private String programexternalid;

    private String programid;

    private String programname;

    private String recoverytime;

    private String resourceexternalid;

    private String resourceid;

    private String resourcename;

    private String resourcetimezone;

    private String scheduletypeid;

    private String sequencenumber;

    private String setuptime;

    private String userexternalid;

    private String userfirstname;

    private String userid;

    private String userlastname;

    private String waitlistid;

    public StgAppointment() {}

    public String getActivitycancellationfee() {
        return this.activitycancellationfee;
    }

    public void setActivitycancellationfee(String activitycancellationfee) {
        this.activitycancellationfee = activitycancellationfee;
    }

    public String getActivityexternalid() {
        return this.activityexternalid;
    }

    public void setActivityexternalid(String activityexternalid) {
        this.activityexternalid = activityexternalid;
    }

    public String getActivityid() {
        return this.activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid;
    }

    public String getActivityname() {
        return this.activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getApplyactivitycancellationfee() {
        return this.applyactivitycancellationfee;
    }

    public void setApplyactivitycancellationfee(String applyactivitycancellationfee) {
        this.applyactivitycancellationfee = applyactivitycancellationfee;
    }

    public String getApplyprcancellationfee() {
        return this.applyprcancellationfee;
    }

    public void setApplyprcancellationfee(String applyprcancellationfee) {
        this.applyprcancellationfee = applyprcancellationfee;
    }

    public String getAppointmentdurationlabel() {
        return this.appointmentdurationlabel;
    }

    public void setAppointmentdurationlabel(String appointmentdurationlabel) {
        this.appointmentdurationlabel = appointmentdurationlabel;
    }

    public String getAppointmentend() {
        return this.appointmentend;
    }

    public void setAppointmentend(String appointmentend) {
        this.appointmentend = appointmentend;
    }

    public String getAppointmentexternalid() {
        return this.appointmentexternalid;
    }

    public void setAppointmentexternalid(String appointmentexternalid) {
        this.appointmentexternalid = appointmentexternalid;
    }

    public String getAppointmentid() {
        return this.appointmentid;
    }

    public void setAppointmentid(String appointmentid) {
        this.appointmentid = appointmentid;
    }

    public String getAppointmentstart() {
        return this.appointmentstart;
    }

    public void setAppointmentstart(String appointmentstart) {
        this.appointmentstart = appointmentstart;
    }

    public String getApptgroupid() {
        return this.apptgroupid;
    }

    public void setApptgroupid(String apptgroupid) {
        this.apptgroupid = apptgroupid;
    }

    public String getApptsetid() {
        return this.apptsetid;
    }

    public void setApptsetid(String apptsetid) {
        this.apptsetid = apptsetid;
    }

    public String getAttendees() {
        return this.attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public String getCampaignid() {
        return this.campaignid;
    }

    public void setCampaignid(String campaignid) {
        this.campaignid = campaignid;
    }

    public String getCampaignname() {
        return this.campaignname;
    }

    public void setCampaignname(String campaignname) {
        this.campaignname = campaignname;
    }

    public String getCampaigntimezone() {
        return this.campaigntimezone;
    }

    public void setCampaigntimezone(String campaigntimezone) {
        this.campaigntimezone = campaigntimezone;
    }

    public String getCancellationtype() {
        return this.cancellationtype;
    }

    public void setCancellationtype(String cancellationtype) {
        this.cancellationtype = cancellationtype;
    }

    public String getCancellationtypeid() {
        return this.cancellationtypeid;
    }

    public void setCancellationtypeid(String cancellationtypeid) {
        this.cancellationtypeid = cancellationtypeid;
    }

    public String getCancelledbyfirstname() {
        return this.cancelledbyfirstname;
    }

    public void setCancelledbyfirstname(String cancelledbyfirstname) {
        this.cancelledbyfirstname = cancelledbyfirstname;
    }

    public String getCancelledbylastname() {
        return this.cancelledbylastname;
    }

    public void setCancelledbylastname(String cancelledbylastname) {
        this.cancelledbylastname = cancelledbylastname;
    }

    public String getCancelledbyuserexternalid() {
        return this.cancelledbyuserexternalid;
    }

    public void setCancelledbyuserexternalid(String cancelledbyuserexternalid) {
        this.cancelledbyuserexternalid = cancelledbyuserexternalid;
    }

    public String getCancelledbyuserid() {
        return this.cancelledbyuserid;
    }

    public void setCancelledbyuserid(String cancelledbyuserid) {
        this.cancelledbyuserid = cancelledbyuserid;
    }

    public String getCancelleddate() {
        return this.cancelleddate;
    }

    public void setCancelleddate(String cancelleddate) {
        this.cancelleddate = cancelleddate;
    }

    public String getClienttimezone() {
        return this.clienttimezone;
    }

    public void setClienttimezone(String clienttimezone) {
        this.clienttimezone = clienttimezone;
    }

    public String getCloseouttime() {
        return this.closeouttime;
    }

    public void setCloseouttime(String closeouttime) {
        this.closeouttime = closeouttime;
    }

    public String getCompletedworkflowsteps() {
        return this.completedworkflowsteps;
    }

    public void setCompletedworkflowsteps(String completedworkflowsteps) {
        this.completedworkflowsteps = completedworkflowsteps;
    }

    public String getConfirmationnumber() {
        return this.confirmationnumber;
    }

    public void setConfirmationnumber(String confirmationnumber) {
        this.confirmationnumber = confirmationnumber;
    }

    public String getCreatedbyuserexternalid() {
        return this.createdbyuserexternalid;
    }

    public void setCreatedbyuserexternalid(String createdbyuserexternalid) {
        this.createdbyuserexternalid = createdbyuserexternalid;
    }

    public String getCreatedbyuserfirstname() {
        return this.createdbyuserfirstname;
    }

    public void setCreatedbyuserfirstname(String createdbyuserfirstname) {
        this.createdbyuserfirstname = createdbyuserfirstname;
    }

    public String getCreatedbyuserid() {
        return this.createdbyuserid;
    }

    public void setCreatedbyuserid(String createdbyuserid) {
        this.createdbyuserid = createdbyuserid;
    }

    public String getCreatedbyuserlastname() {
        return this.createdbyuserlastname;
    }

    public void setCreatedbyuserlastname(String createdbyuserlastname) {
        this.createdbyuserlastname = createdbyuserlastname;
    }

    public String getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public String getDAppointmentmultilocationid() {
        return this.dAppointmentmultilocationid;
    }

    public void setDAppointmentmultilocationid(String dAppointmentmultilocationid) {
        this.dAppointmentmultilocationid = dAppointmentmultilocationid;
    }

    public String getDIsmultilocationhostD() {
        return this.dIsmultilocationhostD;
    }

    public void setDIsmultilocationhostD(String dIsmultilocationhostD) {
        this.dIsmultilocationhostD = dIsmultilocationhostD;
    }

    public String getDuration() {
        return this.duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getInitialappointmentid() {
        return this.initialappointmentid;
    }

    public void setInitialappointmentid(String initialappointmentid) {
        this.initialappointmentid = initialappointmentid;
    }

    public String getInitialduration() {
        return this.initialduration;
    }

    public void setInitialduration(String initialduration) {
        this.initialduration = initialduration;
    }

    public String getIscancelled() {
        return this.iscancelled;
    }

    public void setIscancelled(String iscancelled) {
        this.iscancelled = iscancelled;
    }

    public String getIscheckedin() {
        return this.ischeckedin;
    }

    public void setIscheckedin(String ischeckedin) {
        this.ischeckedin = ischeckedin;
    }

    public String getIscheckedout() {
        return this.ischeckedout;
    }

    public void setIscheckedout(String ischeckedout) {
        this.ischeckedout = ischeckedout;
    }

    public String getIsconfirmed() {
        return this.isconfirmed;
    }

    public void setIsconfirmed(String isconfirmed) {
        this.isconfirmed = isconfirmed;
    }

    public String getIslatecanceled() {
        return this.islatecanceled;
    }

    public void setIslatecanceled(String islatecanceled) {
        this.islatecanceled = islatecanceled;
    }

    public String getIsworkflowcompleted() {
        return this.isworkflowcompleted;
    }

    public void setIsworkflowcompleted(String isworkflowcompleted) {
        this.isworkflowcompleted = isworkflowcompleted;
    }

    public String getIsworkflowenabled() {
        return this.isworkflowenabled;
    }

    public void setIsworkflowenabled(String isworkflowenabled) {
        this.isworkflowenabled = isworkflowenabled;
    }

    public String getLicenseeid() {
        return this.licenseeid;
    }

    public void setLicenseeid(String licenseeid) {
        this.licenseeid = licenseeid;
    }

    public String getLocationid() {
        return this.locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public String getLocationname() {
        return this.locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }

    public String getPaymenttypeid() {
        return this.paymenttypeid;
    }

    public void setPaymenttypeid(String paymenttypeid) {
        this.paymenttypeid = paymenttypeid;
    }

    public String getPaymenttypename() {
        return this.paymenttypename;
    }

    public void setPaymenttypename(String paymenttypename) {
        this.paymenttypename = paymenttypename;
    }

    public String getPrcancellationfee() {
        return this.prcancellationfee;
    }

    public void setPrcancellationfee(String prcancellationfee) {
        this.prcancellationfee = prcancellationfee;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrimaryresourceprice() {
        return this.primaryresourceprice;
    }

    public void setPrimaryresourceprice(String primaryresourceprice) {
        this.primaryresourceprice = primaryresourceprice;
    }

    public String getProgramexternalid() {
        return this.programexternalid;
    }

    public void setProgramexternalid(String programexternalid) {
        this.programexternalid = programexternalid;
    }

    public String getProgramid() {
        return this.programid;
    }

    public void setProgramid(String programid) {
        this.programid = programid;
    }

    public String getProgramname() {
        return this.programname;
    }

    public void setProgramname(String programname) {
        this.programname = programname;
    }

    public String getRecoverytime() {
        return this.recoverytime;
    }

    public void setRecoverytime(String recoverytime) {
        this.recoverytime = recoverytime;
    }

    public String getResourceexternalid() {
        return this.resourceexternalid;
    }

    public void setResourceexternalid(String resourceexternalid) {
        this.resourceexternalid = resourceexternalid;
    }

    public String getResourceid() {
        return this.resourceid;
    }

    public void setResourceid(String resourceid) {
        this.resourceid = resourceid;
    }

    public String getResourcename() {
        return this.resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getResourcetimezone() {
        return this.resourcetimezone;
    }

    public void setResourcetimezone(String resourcetimezone) {
        this.resourcetimezone = resourcetimezone;
    }

    public String getScheduletypeid() {
        return this.scheduletypeid;
    }

    public void setScheduletypeid(String scheduletypeid) {
        this.scheduletypeid = scheduletypeid;
    }

    public String getSequencenumber() {
        return this.sequencenumber;
    }

    public void setSequencenumber(String sequencenumber) {
        this.sequencenumber = sequencenumber;
    }

    public String getSetuptime() {
        return this.setuptime;
    }

    public void setSetuptime(String setuptime) {
        this.setuptime = setuptime;
    }

    public String getUserexternalid() {
        return this.userexternalid;
    }

    public void setUserexternalid(String userexternalid) {
        this.userexternalid = userexternalid;
    }

    public String getUserfirstname() {
        return this.userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserlastname() {
        return this.userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public String getWaitlistid() {
        return this.waitlistid;
    }

    public void setWaitlistid(String waitlistid) {
        this.waitlistid = waitlistid;
    }
}
