package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the APPOINTMENT_SERIES database table.
 *
 */
@Entity
@Table(name = "APPOINTMENT_SERIES")
@NamedQuery(name = "AppointmentSery.findAll", query = "SELECT a FROM AppointmentSery a")
public class AppointmentSery implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APPOINTMENT_SERIES_ID")
    private long appointmentSeriesId;

    @Column(name = "BAND_NAME")
    private String bandName;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "IS_RECURRING")
    private String isRecurring;

    private String note;

    @Column(name = "SERIES_END_TIME")
    private Object seriesEndTime;

    @Column(name = "SERIES_START_TIME")
    private Object seriesStartTime;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Appointment
    @OneToMany(mappedBy = "appointmentSery")
    private List<Appointment> appointments;

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

    //bi-directional many-to-many association to Customer
    @ManyToMany(mappedBy = "appointmentSeries")
    private List<Customer> customers;

    public AppointmentSery() {}

    public long getAppointmentSeriesId() {
        return this.appointmentSeriesId;
    }

    public void setAppointmentSeriesId(long appointmentSeriesId) {
        this.appointmentSeriesId = appointmentSeriesId;
    }

    public String getBandName() {
        return this.bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getIsRecurring() {
        return this.isRecurring;
    }

    public void setIsRecurring(String isRecurring) {
        this.isRecurring = isRecurring;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Object getSeriesEndTime() {
        return this.seriesEndTime;
    }

    public void setSeriesEndTime(Object seriesEndTime) {
        this.seriesEndTime = seriesEndTime;
    }

    public Object getSeriesStartTime() {
        return this.seriesStartTime;
    }

    public void setSeriesStartTime(Object seriesStartTime) {
        this.seriesStartTime = seriesStartTime;
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

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Appointment addAppointment(Appointment appointment) {
        getAppointments().add(appointment);
        appointment.setAppointmentSery(this);

        return appointment;
    }

    public Appointment removeAppointment(Appointment appointment) {
        getAppointments().remove(appointment);
        appointment.setAppointmentSery(null);

        return appointment;
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

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
