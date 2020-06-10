package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the QRTZ_CALENDARS database table.
 *
 */
@Entity
@Table(name = "QRTZ_CALENDARS")
@NamedQuery(name = "QrtzCalendar.findAll", query = "SELECT q FROM QrtzCalendar q")
public class QrtzCalendar implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CALENDAR_NAME")
    private String calendarName;

    @Lob
    private byte[] calendar;

    public QrtzCalendar() {}

    public String getCalendarName() {
        return this.calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public byte[] getCalendar() {
        return this.calendar;
    }

    public void setCalendar(byte[] calendar) {
        this.calendar = calendar;
    }
}
