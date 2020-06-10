package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the STG_REJECTED_RECORD database table.
 *
 */
@Entity
@Table(name = "STG_REJECTED_RECORD")
@NamedQuery(name = "StgRejectedRecord.findAll", query = "SELECT s FROM StgRejectedRecord s")
public class StgRejectedRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "ERROR_CODE")
    private String errorCode;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;

    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "\"KEY\"")
    private String key;

    @Column(name = "TABLE_NAME")
    private String tableName;

    public StgRejectedRecord() {}

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
