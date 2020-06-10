package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_JOB_LISTENERS database table.
 *
 */
@Entity
@Table(name = "QRTZ_JOB_LISTENERS")
@NamedQuery(name = "QrtzJobListener.findAll", query = "SELECT q FROM QrtzJobListener q")
public class QrtzJobListener implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private QrtzJobListenerPK id;

    //bi-directional many-to-one association to QrtzJobDetail
    @ManyToOne
    @JoinColumns(
        {
            @JoinColumn(name = "JOB_GROUP", referencedColumnName = "JOB_GROUP"),
            @JoinColumn(name = "JOB_NAME", referencedColumnName = "JOB_NAME"),
        }
    )
    private QrtzJobDetail qrtzJobDetail;

    public QrtzJobListener() {}

    public QrtzJobListenerPK getId() {
        return this.id;
    }

    public void setId(QrtzJobListenerPK id) {
        this.id = id;
    }

    public QrtzJobDetail getQrtzJobDetail() {
        return this.qrtzJobDetail;
    }

    public void setQrtzJobDetail(QrtzJobDetail qrtzJobDetail) {
        this.qrtzJobDetail = qrtzJobDetail;
    }
}
