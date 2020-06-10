package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_LOCKS database table.
 *
 */
@Entity
@Table(name = "QRTZ_LOCKS")
@NamedQuery(name = "QrtzLock.findAll", query = "SELECT q FROM QrtzLock q")
public class QrtzLock implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCK_NAME")
    private String lockName;

    public QrtzLock() {}

    public String getLockName() {
        return this.lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }
}
