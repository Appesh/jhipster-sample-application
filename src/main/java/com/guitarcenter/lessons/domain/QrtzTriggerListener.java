package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_TRIGGER_LISTENERS database table.
 *
 */
@Entity
@Table(name = "QRTZ_TRIGGER_LISTENERS")
@NamedQuery(name = "QrtzTriggerListener.findAll", query = "SELECT q FROM QrtzTriggerListener q")
public class QrtzTriggerListener implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private QrtzTriggerListenerPK id;

    //bi-directional many-to-one association to QrtzTrigger
    @ManyToOne
    @JoinColumns(
        {
            @JoinColumn(name = "TRIGGER_GROUP", referencedColumnName = "TRIGGER_GROUP"),
            @JoinColumn(name = "TRIGGER_NAME", referencedColumnName = "TRIGGER_NAME"),
        }
    )
    private QrtzTrigger qrtzTrigger;

    public QrtzTriggerListener() {}

    public QrtzTriggerListenerPK getId() {
        return this.id;
    }

    public void setId(QrtzTriggerListenerPK id) {
        this.id = id;
    }

    public QrtzTrigger getQrtzTrigger() {
        return this.qrtzTrigger;
    }

    public void setQrtzTrigger(QrtzTrigger qrtzTrigger) {
        this.qrtzTrigger = qrtzTrigger;
    }
}
