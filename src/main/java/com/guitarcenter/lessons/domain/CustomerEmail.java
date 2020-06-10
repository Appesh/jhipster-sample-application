package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

/**
 * The persistent class for the CUSTOMER_EMAIL database table.
 *
 */
@Entity
@Table(name = "CUSTOMER_EMAIL")
@NamedQuery(name = "CustomerEmail.findAll", query = "SELECT c FROM CustomerEmail c")
public class CustomerEmail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_EMAIL_ID")
    private long customerEmailId;

    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;

    @Column(name = "EXTERNAL_CUSTOMER_ID")
    private String externalCustomerId;

    @Column(name = "EXTERNAL_SOURCE")
    private String externalSource;

    private Object updated;

    @Column(name = "UPDATED_BY")
    private BigDecimal updatedBy;

    public CustomerEmail() {}

    public long getCustomerEmailId() {
        return this.customerEmailId;
    }

    public void setCustomerEmailId(long customerEmailId) {
        this.customerEmailId = customerEmailId;
    }

    public String getCustomerEmail() {
        return this.customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getExternalCustomerId() {
        return this.externalCustomerId;
    }

    public void setExternalCustomerId(String externalCustomerId) {
        this.externalCustomerId = externalCustomerId;
    }

    public String getExternalSource() {
        return this.externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public Object getUpdated() {
        return this.updated;
    }

    public void setUpdated(Object updated) {
        this.updated = updated;
    }

    public BigDecimal getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(BigDecimal updatedBy) {
        this.updatedBy = updatedBy;
    }
}
