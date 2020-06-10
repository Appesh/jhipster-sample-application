package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_SCHEDULER_STATE database table.
 *
 */
@Entity
@Table(name = "QRTZ_SCHEDULER_STATE")
@NamedQuery(name = "QrtzSchedulerState.findAll", query = "SELECT q FROM QrtzSchedulerState q")
public class QrtzSchedulerState implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INSTANCE_NAME")
    private String instanceName;

    @Column(name = "CHECKIN_INTERVAL")
    private BigDecimal checkinInterval;

    @Column(name = "LAST_CHECKIN_TIME")
    private BigDecimal lastCheckinTime;

    public QrtzSchedulerState() {}

    public String getInstanceName() {
        return this.instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public BigDecimal getCheckinInterval() {
        return this.checkinInterval;
    }

    public void setCheckinInterval(BigDecimal checkinInterval) {
        this.checkinInterval = checkinInterval;
    }

    public BigDecimal getLastCheckinTime() {
        return this.lastCheckinTime;
    }

    public void setLastCheckinTime(BigDecimal lastCheckinTime) {
        this.lastCheckinTime = lastCheckinTime;
    }
}
