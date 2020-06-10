package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_FIRED_TRIGGERS database table.
 *
 */
@Entity
@Table(name = "QRTZ_FIRED_TRIGGERS")
@NamedQuery(name = "QrtzFiredTrigger.findAll", query = "SELECT q FROM QrtzFiredTrigger q")
public class QrtzFiredTrigger implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENTRY_ID")
    private String entryId;

    @Column(name = "FIRED_TIME")
    private BigDecimal firedTime;

    @Column(name = "INSTANCE_NAME")
    private String instanceName;

    @Column(name = "IS_STATEFUL")
    private String isStateful;

    @Column(name = "IS_VOLATILE")
    private String isVolatile;

    @Column(name = "JOB_GROUP")
    private String jobGroup;

    @Column(name = "JOB_NAME")
    private String jobName;

    private BigDecimal priority;

    @Column(name = "REQUESTS_RECOVERY")
    private String requestsRecovery;

    @Column(name = "\"STATE\"")
    private String state;

    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

    @Column(name = "TRIGGER_NAME")
    private String triggerName;

    public QrtzFiredTrigger() {}

    public String getEntryId() {
        return this.entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }

    public BigDecimal getFiredTime() {
        return this.firedTime;
    }

    public void setFiredTime(BigDecimal firedTime) {
        this.firedTime = firedTime;
    }

    public String getInstanceName() {
        return this.instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
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

    public String getJobGroup() {
        return this.jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobName() {
        return this.jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public BigDecimal getPriority() {
        return this.priority;
    }

    public void setPriority(BigDecimal priority) {
        this.priority = priority;
    }

    public String getRequestsRecovery() {
        return this.requestsRecovery;
    }

    public void setRequestsRecovery(String requestsRecovery) {
        this.requestsRecovery = requestsRecovery;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTriggerGroup() {
        return this.triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getTriggerName() {
        return this.triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }
}
