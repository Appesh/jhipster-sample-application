package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the CUSTOMER_STATUS database table.
 *
 */
@Entity
@Table(name = "CUSTOMER_STATUS")
@NamedQuery(name = "CustomerStatus.findAll", query = "SELECT c FROM CustomerStatus c")
public class CustomerStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_STATUS_ID")
    private long customerStatusId;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "STATUS_NAME")
    private String statusName;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Customer
    @OneToMany(mappedBy = "customerStatus")
    private List<Customer> customers;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    public CustomerStatus() {}

    public long getCustomerStatusId() {
        return this.customerStatusId;
    }

    public void setCustomerStatusId(long customerStatusId) {
        this.customerStatusId = customerStatusId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Object getUpdated() {
        return this.updated;
    }

    public void setUpdated(Object updated) {
        this.updated = updated;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer addCustomer(Customer customer) {
        getCustomers().add(customer);
        customer.setCustomerStatus(this);

        return customer;
    }

    public Customer removeCustomer(Customer customer) {
        getCustomers().remove(customer);
        customer.setCustomerStatus(null);

        return customer;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Site getSite() {
        return this.site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
