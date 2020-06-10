package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the APPOINTMENT database table.
 *
 */
@Entity
@NamedQuery(name = "Appointment.findAll", query = "SELECT a FROM Appointment a")
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPOINTMENT_ID")
    private long appointmentId;

    @Column(name = "BAND_NAME")
    private String bandName;

    private String canceled;

    @Column(name = "CREATE_TIME")
    private Object createTime;

    @Column(name = "END_TIME")
    private Object endTime;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    private String note;

    @Column(name = "START_TIME")
    private Object startTime;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Activity
    @ManyToOne
    @JoinColumn(name = "ACTIVITY_ID")
    private Activity activity;

    //bi-directional many-to-one association to AppointmentSery
    @ManyToOne
    @JoinColumn(name = "APPOINTMENT_SERIES_ID")
    private AppointmentSery appointmentSery;

    //bi-directional many-to-one association to Instructor
    @ManyToOne
    @JoinColumn(name = "INSTRUCTOR_ID")
    private Instructor instructor;

    //bi-directional many-to-one association to LocationProfile
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private LocationProfile locationProfile;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Room
    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional one-to-one association to AppointmentBook
    @OneToOne(mappedBy = "appointment")
    private AppointmentBook appointmentBook;

    //bi-directional many-to-one association to AppointmentBookTransaction
    @OneToMany(mappedBy = "appointment")
    private List<AppointmentBookTransaction> appointmentBookTransactions;

    //bi-directional many-to-many association to AppointmentCancelReason
    @ManyToMany(mappedBy = "appointments")
    private List<AppointmentCancelReason> appointmentCancelReasons;

    //bi-directional many-to-one association to AppointmentLog
    @OneToMany(mappedBy = "appointment")
    private List<AppointmentLog> appointmentLogs;

    //bi-directional one-to-one association to InstructorAppointmentStatus
    @OneToOne(mappedBy = "appointment")
    private InstructorAppointmentStatus instructorAppointmentStatus;

    public Appointment() {}

    public long getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getBandName() {
        return this.bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getCanceled() {
        return this.canceled;
    }

    public void setCanceled(String canceled) {
        this.canceled = canceled;
    }

    public Object getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Object endTime) {
        this.endTime = endTime;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Object getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Object startTime) {
        this.startTime = startTime;
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

    public AppointmentSery getAppointmentSery() {
        return this.appointmentSery;
    }

    public void setAppointmentSery(AppointmentSery appointmentSery) {
        this.appointmentSery = appointmentSery;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
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

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public AppointmentBook getAppointmentBook() {
        return this.appointmentBook;
    }

    public void setAppointmentBook(AppointmentBook appointmentBook) {
        this.appointmentBook = appointmentBook;
    }

    public List<AppointmentBookTransaction> getAppointmentBookTransactions() {
        return this.appointmentBookTransactions;
    }

    public void setAppointmentBookTransactions(List<AppointmentBookTransaction> appointmentBookTransactions) {
        this.appointmentBookTransactions = appointmentBookTransactions;
    }

    public AppointmentBookTransaction addAppointmentBookTransaction(AppointmentBookTransaction appointmentBookTransaction) {
        getAppointmentBookTransactions().add(appointmentBookTransaction);
        appointmentBookTransaction.setAppointment(this);

        return appointmentBookTransaction;
    }

    public AppointmentBookTransaction removeAppointmentBookTransaction(AppointmentBookTransaction appointmentBookTransaction) {
        getAppointmentBookTransactions().remove(appointmentBookTransaction);
        appointmentBookTransaction.setAppointment(null);

        return appointmentBookTransaction;
    }

    public List<AppointmentCancelReason> getAppointmentCancelReasons() {
        return this.appointmentCancelReasons;
    }

    public void setAppointmentCancelReasons(List<AppointmentCancelReason> appointmentCancelReasons) {
        this.appointmentCancelReasons = appointmentCancelReasons;
    }

    public List<AppointmentLog> getAppointmentLogs() {
        return this.appointmentLogs;
    }

    public void setAppointmentLogs(List<AppointmentLog> appointmentLogs) {
        this.appointmentLogs = appointmentLogs;
    }

    public AppointmentLog addAppointmentLog(AppointmentLog appointmentLog) {
        getAppointmentLogs().add(appointmentLog);
        appointmentLog.setAppointment(this);

        return appointmentLog;
    }

    public AppointmentLog removeAppointmentLog(AppointmentLog appointmentLog) {
        getAppointmentLogs().remove(appointmentLog);
        appointmentLog.setAppointment(null);

        return appointmentLog;
    }

    public InstructorAppointmentStatus getInstructorAppointmentStatus() {
        return this.instructorAppointmentStatus;
    }

    public void setInstructorAppointmentStatus(InstructorAppointmentStatus instructorAppointmentStatus) {
        this.instructorAppointmentStatus = instructorAppointmentStatus;
    }
}
