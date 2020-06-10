package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the TFLOWMETER_CATCHER database table.
 *
 */
@Entity
@Table(name = "TFLOWMETER_CATCHER")
@NamedQuery(name = "TflowmeterCatcher.findAll", query = "SELECT t FROM TflowmeterCatcher t")
public class TflowmeterCatcher implements Serializable {
    private static final long serialVersionUID = 1L;

    private String context;

    @Column(name = "\"COUNT\"")
    private BigDecimal count;

    @Column(name = "FATHER_PID")
    private String fatherPid;

    private String job;

    @Column(name = "JOB_REPOSITORY_ID")
    private String jobRepositoryId;

    @Column(name = "JOB_VERSION")
    private String jobVersion;

    @Column(name = "\"LABEL\"")
    private String label;

    @Temporal(TemporalType.DATE)
    private Date moment;

    private String origin;

    private String pid;

    private String project;

    private BigDecimal reference;

    @Column(name = "ROOT_PID")
    private String rootPid;

    @Column(name = "SYSTEM_PID")
    private BigDecimal systemPid;

    private String thresholds;

    public TflowmeterCatcher() {}

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public BigDecimal getCount() {
        return this.count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
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

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public BigDecimal getReference() {
        return this.reference;
    }

    public void setReference(BigDecimal reference) {
        this.reference = reference;
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

    public String getThresholds() {
        return this.thresholds;
    }

    public void setThresholds(String thresholds) {
        this.thresholds = thresholds;
    }
}
