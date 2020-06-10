package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the APPOINTMENT_BOOK_TRANSACTION database table.
 *
 */
@Entity
@Table(name = "APPOINTMENT_BOOK_TRANSACTION")
@NamedQuery(name = "AppointmentBookTransaction.findAll", query = "SELECT a FROM AppointmentBookTransaction a")
public class AppointmentBookTransaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "BOOK_TYPE")
    private String bookType;

    @Column(name = "CUSTOMER_EXTERNAL_ID")
    private String customerExternalId;

    private BigDecimal duration;

    @Column(name = "ERROR_INFO")
    private String errorInfo;

    @Column(name = "EXTERNAL_SOURCE")
    private String externalSource;

    @Column(name = "INSTRUCTOR_EXTERNAL_ID")
    private String instructorExternalId;

    @Column(name = "LESSON_BOOK_CD")
    private String lessonBookCd;

    @Column(name = "LOCATION_EXTERNAL_ID")
    private String locationExternalId;

    @Column(name = "MANAGER_APPROVAL")
    private BigDecimal managerApproval;

    @Column(name = "POS_REFERENCE_NUMBER")
    private String posReferenceNumber;

    private BigDecimal site;

    private String status;

    private Object updated;

    @Column(name = "UPDATED_BY")
    private BigDecimal updatedBy;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Appointment
    @ManyToOne
    @JoinColumn(name = "APPOINTMENT_ID")
    private Appointment appointment;

    public AppointmentBookTransaction() {}

    public long getOrderId() {
        return this.orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getBookType() {
        return this.bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getCustomerExternalId() {
        return this.customerExternalId;
    }

    public void setCustomerExternalId(String customerExternalId) {
        this.customerExternalId = customerExternalId;
    }

    public BigDecimal getDuration() {
        return this.duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getExternalSource() {
        return this.externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public String getInstructorExternalId() {
        return this.instructorExternalId;
    }

    public void setInstructorExternalId(String instructorExternalId) {
        this.instructorExternalId = instructorExternalId;
    }

    public String getLessonBookCd() {
        return this.lessonBookCd;
    }

    public void setLessonBookCd(String lessonBookCd) {
        this.lessonBookCd = lessonBookCd;
    }

    public String getLocationExternalId() {
        return this.locationExternalId;
    }

    public void setLocationExternalId(String locationExternalId) {
        this.locationExternalId = locationExternalId;
    }

    public BigDecimal getManagerApproval() {
        return this.managerApproval;
    }

    public void setManagerApproval(BigDecimal managerApproval) {
        this.managerApproval = managerApproval;
    }

    public String getPosReferenceNumber() {
        return this.posReferenceNumber;
    }

    public void setPosReferenceNumber(String posReferenceNumber) {
        this.posReferenceNumber = posReferenceNumber;
    }

    public BigDecimal getSite() {
        return this.site;
    }

    public void setSite(BigDecimal site) {
        this.site = site;
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

    public Appointment getAppointment() {
        return this.appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
