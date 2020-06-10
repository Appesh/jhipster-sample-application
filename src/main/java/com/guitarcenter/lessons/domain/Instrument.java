package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the INSTRUMENT database table.
 *
 */
@Entity
@NamedQuery(name = "Instrument.findAll", query = "SELECT i FROM Instrument i")
public class Instrument implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INSTRUMENT_ID")
    private long instrumentId;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "INSTRUMENT_NAME")
    private String instrumentName;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-many association to Customer
    @ManyToMany(mappedBy = "instruments")
    private List<Customer> customers;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    public Instrument() {}

    public long getInstrumentId() {
        return this.instrumentId;
    }

    public void setInstrumentId(long instrumentId) {
        this.instrumentId = instrumentId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getInstrumentName() {
        return this.instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
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
