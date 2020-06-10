package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the CUSTOMER database table.
 *
 */
@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private long customerId;

    @Column(name = "BADGE_NUMBER")
    private String badgeNumber;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "EXTERNAL_SOURCE")
    private String externalSource;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_BOOKED")
    private Date lastBooked;

    @Column(name = "LESSON_COUNT")
    private String lessonCount;

    @Column(name = "LOCATION_EXTERNAL_ID")
    private String locationExternalId;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to AppointmentCustomer
    @OneToMany(mappedBy = "customer")
    private List<AppointmentCustomer> appointmentCustomers;

    //bi-directional many-to-one association to CustomerStatus
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_STATUS_ID")
    private CustomerStatus customerStatus;

    //bi-directional many-to-one association to ParentDetail
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private ParentDetail parentDetail;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person1;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person2;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional many-to-many association to AppointmentSery
    @ManyToMany
    @JoinTable(
        name = "CUSTOMER_APPOINTMENT_SERIES",
        joinColumns = { @JoinColumn(name = "CUSTOMER_ID") },
        inverseJoinColumns = { @JoinColumn(name = "APPOINTMENT_SERIES_ID") }
    )
    private List<AppointmentSery> appointmentSeries;

    //bi-directional many-to-many association to Instrument
    @ManyToMany
    @JoinTable(
        name = "CUSTOMER_INSTRUMENT",
        joinColumns = { @JoinColumn(name = "CUSTOMER_ID") },
        inverseJoinColumns = { @JoinColumn(name = "INSTRUMENT_ID") }
    )
    private List<Instrument> instruments;

    public Customer() {}

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getBadgeNumber() {
        return this.badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
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

    public Date getLastBooked() {
        return this.lastBooked;
    }

    public void setLastBooked(Date lastBooked) {
        this.lastBooked = lastBooked;
    }

    public String getLessonCount() {
        return this.lessonCount;
    }

    public void setLessonCount(String lessonCount) {
        this.lessonCount = lessonCount;
    }

    public String getLocationExternalId() {
        return this.locationExternalId;
    }

    public void setLocationExternalId(String locationExternalId) {
        this.locationExternalId = locationExternalId;
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

    public List<AppointmentCustomer> getAppointmentCustomers() {
        return this.appointmentCustomers;
    }

    public void setAppointmentCustomers(List<AppointmentCustomer> appointmentCustomers) {
        this.appointmentCustomers = appointmentCustomers;
    }

    public AppointmentCustomer addAppointmentCustomer(AppointmentCustomer appointmentCustomer) {
        getAppointmentCustomers().add(appointmentCustomer);
        appointmentCustomer.setCustomer(this);

        return appointmentCustomer;
    }

    public AppointmentCustomer removeAppointmentCustomer(AppointmentCustomer appointmentCustomer) {
        getAppointmentCustomers().remove(appointmentCustomer);
        appointmentCustomer.setCustomer(null);

        return appointmentCustomer;
    }

    public CustomerStatus getCustomerStatus() {
        return this.customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public ParentDetail getParentDetail() {
        return this.parentDetail;
    }

    public void setParentDetail(ParentDetail parentDetail) {
        this.parentDetail = parentDetail;
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

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public List<AppointmentSery> getAppointmentSeries() {
        return this.appointmentSeries;
    }

    public void setAppointmentSeries(List<AppointmentSery> appointmentSeries) {
        this.appointmentSeries = appointmentSeries;
    }

    public List<Instrument> getInstruments() {
        return this.instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }
}
