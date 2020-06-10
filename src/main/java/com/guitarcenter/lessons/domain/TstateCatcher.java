package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the TSTATE_CATCHER database table.
 *
 */
@Entity
@Table(name = "TSTATE_CATCHER")
@NamedQuery(name = "TstateCatcher.findAll", query = "SELECT t FROM TstateCatcher t")
public class TstateCatcher implements Serializable {
    private static final long serialVersionUID = 1L;

    private String context;

    private BigDecimal duration;

    @Column(name = "FATHER_PID")
    private String fatherPid;

    private String job;

    @Column(name = "JOB_REPOSITORY_ID")
    private String jobRepositoryId;

    @Column(name = "JOB_VERSION")
    private String jobVersion;

    @Column(name = "\"MESSAGE\"")
    private String message;

    @Column(name = "MESSAGE_TYPE")
    private String messageType;

    @Temporal(TemporalType.DATE)
    private Date moment;

    private String origin;

    private String pid;

    private String project;

    @Column(name = "ROOT_PID")
    private String rootPid;

    @Column(name = "SYSTEM_PID")
    private BigDecimal systemPid;

    public TstateCatcher() {}

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public BigDecimal getDuration() {
        return this.duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public String getFatherPid() {
        return this.fatherPid;
    }

    public void setFatherPid(String fatherPid) {
        this.fatherPid = fatherPid;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobRepositoryId() {
        return this.jobRepositoryId;
    }

    public void setJobRepositoryId(String jobRepositoryId) {
        this.jobRepositoryId = jobRepositoryId;
    }

    public String getJobVersion() {
        return this.jobVersion;
    }

    public void setJobVersion(String jobVersion) {
        this.jobVersion = jobVersion;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Date getMoment() {
        return this.moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getRootPid() {
        return this.rootPid;
    }

    public void setRootPid(String rootPid) {
        this.rootPid = rootPid;
    }

    public BigDecimal getSystemPid() {
        return this.systemPid;
    }

    public void setSystemPid(BigDecimal systemPid) {
        this.systemPid = systemPid;
    }
}
