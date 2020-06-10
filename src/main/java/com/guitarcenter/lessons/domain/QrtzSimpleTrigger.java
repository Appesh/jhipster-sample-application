package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_SIMPLE_TRIGGERS database table.
 *
 */
@Entity
@Table(name = "QRTZ_SIMPLE_TRIGGERS")
@NamedQuery(name = "QrtzSimpleTrigger.findAll", query = "SELECT q FROM QrtzSimpleTrigger q")
public class QrtzSimpleTrigger implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private QrtzSimpleTriggerPK id;

    @Column(name = "REPEAT_COUNT")
    private BigDecimal repeatCount;

    @Column(name = "REPEAT_INTERVAL")
    private BigDecimal repeatInterval;

    @Column(name = "TIMES_TRIGGERED")
    private BigDecimal timesTriggered;

    //bi-directional many-to-one association to QrtzTrigger
    @ManyToOne
    @JoinColumns(
        {
            @JoinColumn(name = "TRIGGER_GROUP", referencedColumnName = "TRIGGER_GROUP"),
            @JoinColumn(name = "TRIGGER_NAME", referencedColumnName = "TRIGGER_NAME"),
        }
    )
    private QrtzTrigger qrtzTrigger;

    public QrtzSimpleTrigger() {}

    public QrtzSimpleTriggerPK getId() {
        return this.id;
    }

    public void setId(QrtzSimpleTriggerPK id) {
        this.id = id;
    }

    public BigDecimal getRepeatCount() {
        return this.repeatCount;
    }

    public void setRepeatCount(BigDecimal repeatCount) {
        this.repeatCount = repeatCount;
    }

    public BigDecimal getRepeatInterval() {
        return this.repeatInterval;
    }

    public void setRepeatInterval(BigDecimal repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public BigDecimal getTimesTriggered() {
        return this.timesTriggered;
    }

    public void setTimesTriggered(BigDecimal timesTriggered) {
        this.timesTriggered = timesTriggered;
    }

    public QrtzTrigger getQrtzTrigger() {
        return this.qrtzTrigger;
    }

    public void setQrtzTrigger(QrtzTrigger qrtzTrigger) {
        this.qrtzTrigger = qrtzTrigger;
    }
}
