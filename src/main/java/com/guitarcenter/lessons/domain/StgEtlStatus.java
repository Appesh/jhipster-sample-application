package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * The persistent class for the STG_ETL_STATUS database table.
 *
 */
@Entity
@Table(name = "STG_ETL_STATUS")
@NamedQuery(name = "StgEtlStatus.findAll", query = "SELECT s FROM StgEtlStatus s")
public class StgEtlStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "JOB_ID")
    private BigDecimal jobId;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    private Date startDate;

    private String status;

    public StgEtlStatus() {}

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getJobId() {
        return this.jobId;
    }

    public void setJobId(BigDecimal jobId) {
        this.jobId = jobId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
