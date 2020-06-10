package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_TRIGGERS database table.
 *
 */
@Entity
@Table(name = "QRTZ_TRIGGERS")
@NamedQuery(name = "QrtzTrigger.findAll", query = "SELECT q FROM QrtzTrigger q")
public class QrtzTrigger implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private QrtzTriggerPK id;

    @Column(name = "CALENDAR_NAME")
    private String calendarName;

    private String description;

    @Column(name = "END_TIME")
    private BigDecimal endTime;

    @Column(name = "IS_VOLATILE")
    private String isVolatile;

    @Lob
    @Column(name = "JOB_DATA")
    private byte[] jobData;

    @Column(name = "MISFIRE_INSTR")
    private BigDecimal misfireInstr;

    @Column(name = "NEXT_FIRE_TIME")
    private BigDecimal nextFireTime;

    @Column(name = "PREV_FIRE_TIME")
    private BigDecimal prevFireTime;

    private BigDecimal priority;

    @Column(name = "START_TIME")
    private BigDecimal startTime;

    @Column(name = "TRIGGER_STATE")
    private String triggerState;

    @Column(name = "TRIGGER_TYPE")
    private String triggerType;

    //bi-directional many-to-one association to QrtzBlobTrigger
    @OneToMany(mappedBy = "qrtzTrigger")
    private List<QrtzBlobTrigger> qrtzBlobTriggers;

    //bi-directional many-to-one association to QrtzCronTrigger
    @OneToMany(mappedBy = "qrtzTrigger")
    private List<QrtzCronTrigger> qrtzCronTriggers;

    //bi-directional many-to-one association to QrtzSimpleTrigger
    @OneToMany(mappedBy = "qrtzTrigger")
    private List<QrtzSimpleTrigger> qrtzSimpleTriggers;

    //bi-directional many-to-one association to QrtzJobDetail
    @ManyToOne
    @JoinColumns(
        {
            @JoinColumn(name = "JOB_GROUP", referencedColumnName = "JOB_GROUP"),
            @JoinColumn(name = "JOB_NAME", referencedColumnName = "JOB_NAME"),
        }
    )
    private QrtzJobDetail qrtzJobDetail;

    //bi-directional many-to-one association to QrtzTriggerListener
    @OneToMany(mappedBy = "qrtzTrigger")
    private List<QrtzTriggerListener> qrtzTriggerListeners;

    public QrtzTrigger() {}

    public QrtzTriggerPK getId() {
        return this.id;
    }

    public void setId(QrtzTriggerPK id) {
        this.id = id;
    }

    public String getCalendarName() {
        return this.calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getEndTime() {
        return this.endTime;
    }

    public void setEndTime(BigDecimal endTime) {
        this.endTime = endTime;
    }

    public String getIsVolatile() {
        return this.isVolatile;
    }

    public void setIsVolatile(String isVolatile) {
        this.isVolatile = isVolatile;
    }

    public byte[] getJobData() {
        return this.jobData;
    }

    public void setJobData(byte[] jobData) {
        this.jobData = jobData;
    }

    public BigDecimal getMisfireInstr() {
        return this.misfireInstr;
    }

    public void setMisfireInstr(BigDecimal misfireInstr) {
        this.misfireInstr = misfireInstr;
    }

    public BigDecimal getNextFireTime() {
        return this.nextFireTime;
    }

    public void setNextFireTime(BigDecimal nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public BigDecimal getPrevFireTime() {
        return this.prevFireTime;
    }

    public void setPrevFireTime(BigDecimal prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    public BigDecimal getPriority() {
        return this.priority;
    }

    public void setPriority(BigDecimal priority) {
        this.priority = priority;
    }

    public BigDecimal getStartTime() {
        return this.startTime;
    }

    public void setStartTime(BigDecimal startTime) {
        this.startTime = startTime;
    }

    public String getTriggerState() {
        return this.triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public void setTriggerType(String triggerType) {
        this.triggerType = triggerType;
    }

    public List<QrtzBlobTrigger> getQrtzBlobTriggers() {
        return this.qrtzBlobTriggers;
    }

    public void setQrtzBlobTriggers(List<QrtzBlobTrigger> qrtzBlobTriggers) {
        this.qrtzBlobTriggers = qrtzBlobTriggers;
    }

    public QrtzBlobTrigger addQrtzBlobTrigger(QrtzBlobTrigger qrtzBlobTrigger) {
        getQrtzBlobTriggers().add(qrtzBlobTrigger);
        qrtzBlobTrigger.setQrtzTrigger(this);

        return qrtzBlobTrigger;
    }

    public QrtzBlobTrigger removeQrtzBlobTrigger(QrtzBlobTrigger qrtzBlobTrigger) {
        getQrtzBlobTriggers().remove(qrtzBlobTrigger);
        qrtzBlobTrigger.setQrtzTrigger(null);

        return qrtzBlobTrigger;
    }

    public List<QrtzCronTrigger> getQrtzCronTriggers() {
        return this.qrtzCronTriggers;
    }

    public void setQrtzCronTriggers(List<QrtzCronTrigger> qrtzCronTriggers) {
        this.qrtzCronTriggers = qrtzCronTriggers;
    }

    public QrtzCronTrigger addQrtzCronTrigger(QrtzCronTrigger qrtzCronTrigger) {
        getQrtzCronTriggers().add(qrtzCronTrigger);
        qrtzCronTrigger.setQrtzTrigger(this);

        return qrtzCronTrigger;
    }

    public QrtzCronTrigger removeQrtzCronTrigger(QrtzCronTrigger qrtzCronTrigger) {
        getQrtzCronTriggers().remove(qrtzCronTrigger);
        qrtzCronTrigger.setQrtzTrigger(null);

        return qrtzCronTrigger;
    }

    public List<QrtzSimpleTrigger> getQrtzSimpleTriggers() {
        return this.qrtzSimpleTriggers;
    }

    public void setQrtzSimpleTriggers(List<QrtzSimpleTrigger> qrtzSimpleTriggers) {
        this.qrtzSimpleTriggers = qrtzSimpleTriggers;
    }

    public QrtzSimpleTrigger addQrtzSimpleTrigger(QrtzSimpleTrigger qrtzSimpleTrigger) {
        getQrtzSimpleTriggers().add(qrtzSimpleTrigger);
        qrtzSimpleTrigger.setQrtzTrigger(this);

        return qrtzSimpleTrigger;
    }

    public QrtzSimpleTrigger removeQrtzSimpleTrigger(QrtzSimpleTrigger qrtzSimpleTrigger) {
        getQrtzSimpleTriggers().remove(qrtzSimpleTrigger);
        qrtzSimpleTrigger.setQrtzTrigger(null);

        return qrtzSimpleTrigger;
    }

    public QrtzJobDetail getQrtzJobDetail() {
        return this.qrtzJobDetail;
    }

    public void setQrtzJobDetail(QrtzJobDetail qrtzJobDetail) {
        this.qrtzJobDetail = qrtzJobDetail;
    }

    public List<QrtzTriggerListener> getQrtzTriggerListeners() {
        return this.qrtzTriggerListeners;
    }

    public void setQrtzTriggerListeners(List<QrtzTriggerListener> qrtzTriggerListeners) {
        this.qrtzTriggerListeners = qrtzTriggerListeners;
    }

    public QrtzTriggerListener addQrtzTriggerListener(QrtzTriggerListener qrtzTriggerListener) {
        getQrtzTriggerListeners().add(qrtzTriggerListener);
        qrtzTriggerListener.setQrtzTrigger(this);

        return qrtzTriggerListener;
    }

    public QrtzTriggerListener removeQrtzTriggerListener(QrtzTriggerListener qrtzTriggerListener) {
        getQrtzTriggerListeners().remove(qrtzTriggerListener);
        qrtzTriggerListener.setQrtzTrigger(null);

        return qrtzTriggerListener;
    }
}
