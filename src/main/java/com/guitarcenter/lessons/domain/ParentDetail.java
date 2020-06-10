package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the PARENT_DETAILS database table.
 *
 */
@Entity
@Table(name = "PARENT_DETAILS")
@NamedQuery(name = "ParentDetail.findAll", query = "SELECT p FROM ParentDetail p")
public class ParentDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PARENT_ID")
    private long parentId;

    @Column(name = "EXTERNAL_SOURCE")
    private String externalSource;

    @Column(name = "FULL_NAME")
    private String fullName;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Customer
    @OneToMany(mappedBy = "parentDetail")
    private List<Customer> customers;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    public ParentDetail() {}

    public long getParentId() {
        return this.parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getExternalSource() {
        return this.externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        customer.setParentDetail(this);

        return customer;
    }

    public Customer removeCustomer(Customer customer) {
        getCustomers().remove(customer);
        customer.setParentDetail(null);

        return customer;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
