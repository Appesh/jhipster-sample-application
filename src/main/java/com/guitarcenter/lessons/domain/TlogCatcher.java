package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the TLOG_CATCHER database table.
 *
 */
@Entity
@Table(name = "TLOG_CATCHER")
@NamedQuery(name = "TlogCatcher.findAll", query = "SELECT t FROM TlogCatcher t")
public class TlogCatcher implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal code;

    private String context;

    @Column(name = "FATHER_PID")
    private String fatherPid;

    private String job;

    @Column(name = "\"MESSAGE\"")
    private String message;

    @Temporal(TemporalType.DATE)
    private Date moment;

    private String origin;

    private String pid;

    private BigDecimal priority;

    private String project;

    @Column(name = "ROOT_PID")
    private String rootPid;

    @Column(name = "\"TYPE\"")
    private String type;

    public TlogCatcher() {}

    public BigDecimal getCode() {
        return this.code;
    }

    public void setCode(BigDecimal code) {
        this.code = code;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public BigDecimal getPriority() {
        return this.priority;
    }

    public void setPriority(BigDecimal priority) {
        this.priority = priority;
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

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
