package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_PAUSED_TRIGGER_GRPS database table.
 *
 */
@Entity
@Table(name = "QRTZ_PAUSED_TRIGGER_GRPS")
@NamedQuery(name = "QrtzPausedTriggerGrp.findAll", query = "SELECT q FROM QrtzPausedTriggerGrp q")
public class QrtzPausedTriggerGrp implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

    public QrtzPausedTriggerGrp() {}

    public String getTriggerGroup() {
        return this.triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }
}
