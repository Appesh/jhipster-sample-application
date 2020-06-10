package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the STG_REQUIRED_RECORD database table.
 *
 */
@Entity
@Table(name = "STG_REQUIRED_RECORD")
@NamedQuery(name = "StgRequiredRecord.findAll", query = "SELECT s FROM StgRequiredRecord s")
public class StgRequiredRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "JOB_ID")
    private String jobId;

    @Column(name = "\"KEY\"")
    private String key;

    @Column(name = "TABLE_NAME")
    private String tableName;

    public StgRequiredRecord() {}

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
