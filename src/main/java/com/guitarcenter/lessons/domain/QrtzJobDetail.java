package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_JOB_DETAILS database table.
 *
 */
@Entity
@Table(name = "QRTZ_JOB_DETAILS")
@NamedQuery(name = "QrtzJobDetail.findAll", query = "SELECT q FROM QrtzJobDetail q")
public class QrtzJobDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private QrtzJobDetailPK id;

    private String description;

    @Column(name = "IS_DURABLE")
    private String isDurable;

    @Column(name = "IS_STATEFUL")
    private String isStateful;

    @Column(name = "IS_VOLATILE")
    private String isVolatile;

    @Column(name = "JOB_CLASS_NAME")
    private String jobClassName;

    @Lob
    @Column(name = "JOB_DATA")
    private byte[] jobData;

    @Column(name = "REQUESTS_RECOVERY")
    private String requestsRecovery;

    //bi-directional many-to-one association to QrtzJobListener
    @OneToMany(mappedBy = "qrtzJobDetail")
    private List<QrtzJobListener> qrtzJobListeners;

    //bi-directional many-to-one association to QrtzTrigger
    @OneToMany(mappedBy = "qrtzJobDetail")
    private List<QrtzTrigger> qrtzTriggers;

    public QrtzJobDetail() {}

    public QrtzJobDetailPK getId() {
        return this.id;
    }

    public void setId(QrtzJobDetailPK id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsDurable() {
        return this.isDurable;
    }

    public void setIsDurable(String isDurable) {
        this.isDurable = isDurable;
    }

    public String getIsStateful() {
        return this.isStateful;
    }

    public void setIsStateful(String isStateful) {
        this.isStateful = isStateful;
    }

    public String getIsVolatile() {
        return this.isVolatile;
    }

    public void setIsVolatile(String isVolatile) {
        this.isVolatile = isVolatile;
    }

    public String getJobClassName() {
        return this.jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public byte[] getJobData() {
        return this.jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }

    public String getRequestsRecovery() {
        return this.requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }

    public List<QrtzJobListener> getQrtzJobListeners() {
        return this.qrtzJobListeners;
    }

    public void setQrtzJobListeners(List<QrtzJobListener> qrtzJobListeners) {
        this.qrtzJobListeners = qrtzJobListeners;
    }

    public QrtzJobListener addQrtzJobListener(QrtzJobListener qrtzJobListener) {
        getQrtzJobListeners().add(qrtzJobListener);
        qrtzJobListener.setQrtzJobDetail(this);

        return qrtzJobListener;
    }

    public QrtzJobListener removeQrtzJobListener(QrtzJobListener qrtzJobListener) {
        getQrtzJobListeners().remove(qrtzJobListener);
        qrtzJobListener.setQrtzJobDetail(null);

        return qrtzJobListener;
    }

    public List<QrtzTrigger> getQrtzTriggers() {
        return this.qrtzTriggers;
    }

    public void setQrtzTriggers(List<QrtzTrigger> qrtzTriggers) {
        this.qrtzTriggers = qrtzTriggers;
    }

    public QrtzTrigger addQrtzTrigger(QrtzTrigger qrtzTrigger) {
        getQrtzTriggers().add(qrtzTrigger);
        qrtzTrigger.setQrtzJobDetail(this);

        return qrtzTrigger;
    }

    public QrtzTrigger removeQrtzTrigger(QrtzTrigger qrtzTrigger) {
        getQrtzTriggers().remove(qrtzTrigger);
        qrtzTrigger.setQrtzJobDetail(null);

        return qrtzTrigger;
    }
}
