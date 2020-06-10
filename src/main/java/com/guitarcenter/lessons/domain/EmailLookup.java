package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the EMAIL_LOOKUP database table.
 *
 */
@Entity
@Table(name = "EMAIL_LOOKUP")
@NamedQuery(name = "EmailLookup.findAll", query = "SELECT e FROM EmailLookup e")
public class EmailLookup implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long lookupid;

    private String description;

    private String recipientid;

    public EmailLookup() {}

    public long getLookupid() {
        return this.lookupid;
    }

    public void setLookupid(long lookupid) {
        this.lookupid = lookupid;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecipientid() {
        return this.recipientid;
    }

    public void setRecipientid(String recipientid) {
        this.recipientid = recipientid;
    }
}
