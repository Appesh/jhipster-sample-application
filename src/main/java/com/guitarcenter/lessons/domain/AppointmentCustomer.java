package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the APPOINTMENT_CUSTOMERS database table.
 *
 */
@Entity
@Table(name = "APPOINTMENT_CUSTOMERS")
@NamedQuery(name = "AppointmentCustomer.findAll", query = "SELECT a FROM AppointmentCustomer a")
public class AppointmentCustomer implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AppointmentCustomerPK id;

    //bi-directional many-to-one association to Customer
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    public AppointmentCustomer() {}

    public AppointmentCustomerPK getId() {
        return this.id;
    }

    public void setId(AppointmentCustomerPK id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
