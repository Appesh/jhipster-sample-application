package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_BLOB_TRIGGERS database table.
 *
 */
@Entity
@Table(name = "QRTZ_BLOB_TRIGGERS")
@NamedQuery(name = "QrtzBlobTrigger.findAll", query = "SELECT q FROM QrtzBlobTrigger q")
public class QrtzBlobTrigger implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private QrtzBlobTriggerPK id;

    @Lob
    @Column(name = "BLOB_DATA")
    private byte[] blobData;

    //bi-directional many-to-one association to QrtzTrigger
    @ManyToOne
    @JoinColumns(
        {
            @JoinColumn(name = "TRIGGER_GROUP", referencedColumnName = "TRIGGER_GROUP"),
            @JoinColumn(name = "TRIGGER_NAME", referencedColumnName = "TRIGGER_NAME"),
        }
    )
    private QrtzTrigger qrtzTrigger;

    public QrtzBlobTrigger() {}

    public QrtzBlobTriggerPK getId() {
        return this.id;
    }

    public void setId(QrtzBlobTriggerPK id) {
        this.id = id;
    }

    public byte[] getBlobData() {
        return this.blobData;
    }

    public void setBlobData(byte[] blobData) {
        this.blobData = blobData;
    }

    public QrtzTrigger getQrtzTrigger() {
        return this.qrtzTrigger;
    }

    public void setQrtzTrigger(QrtzTrigger qrtzTrigger) {
        this.qrtzTrigger = qrtzTrigger;
    }
}
