package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the ENVIRONMENT database table.
 *
 */
@Entity
@NamedQuery(name = "Environment.findAll", query = "SELECT e FROM Environment e")
public class Environment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ENVIRONMENT_ID")
    private BigDecimal environmentId;

    @Column(name = "ENVIRONMENT_NAME")
    private String environmentName;

    public Environment() {}

    public BigDecimal getEnvironmentId() {
        return this.environmentId;
    }

    public void setEnvironmentId(BigDecimal environmentId) {
        this.environmentId = environmentId;
    }

    public String getEnvironmentName() {
        return this.environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }
}
