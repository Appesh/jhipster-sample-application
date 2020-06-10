package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the LOCATION database table.
 *
 */
@Entity
@NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOCATION_ID")
    private long locationId;

    @Column(name = "ADDRESS_1")
    private String address1;

    @Column(name = "ADDRESS_2")
    private String address2;

    private String city;

    private String country;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "EXTERNAL_SOURCE")
    private String externalSource;

    private String fax;

    @Column(name = "LOCATION_NAME")
    private String locationName;

    private String phone;

    @Column(name = "\"STATE\"")
    private String state;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    private String zip;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "location")
    private List<Employee> employees;

    //bi-directional many-to-one association to Instructor
    @OneToMany(mappedBy = "location")
    private List<Instructor> instructors;

    //bi-directional many-to-one association to LocationProfile
    @ManyToOne
    @JoinColumn(name = "PROFILE_ID")
    private LocationProfile locationProfile;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Site
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

    //bi-directional one-to-one association to LocationDstReg
    @OneToOne(mappedBy = "location")
    private LocationDstReg locationDstReg;

    //bi-directional many-to-one association to PersonRole
    @OneToMany(mappedBy = "location")
    private List<PersonRole> personRoles;

    public Location() {}

    public long getLocationId() {
        return this.locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalSource() {
        return this.externalSource;
    }

    public void setExternalSource(String externalSource) {
        this.externalSource = externalSource;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee addEmployee(Employee employee) {
        getEmployees().add(employee);
        employee.setLocation(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setLocation(null);

        return employee;
    }

    public List<Instructor> getInstructors() {
        return this.instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Instructor addInstructor(Instructor instructor) {
        getInstructors().add(instructor);
        instructor.setLocation(this);

        return instructor;
    }

    public Instructor removeInstructor(Instructor instructor) {
        getInstructors().remove(instructor);
        instructor.setLocation(null);

        return instructor;
    }

    public LocationProfile getLocationProfile() {
        return this.locationProfile;
    }

    public void setLocationProfile(LocationProfile locationProfile) {
        this.locationProfile = locationProfile;
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

    public LocationDstReg getLocationDstReg() {
        return this.locationDstReg;
    }

    public void setLocationDstReg(LocationDstReg locationDstReg) {
        this.locationDstReg = locationDstReg;
    }

    public List<PersonRole> getPersonRoles() {
        return this.personRoles;
    }

    public void setPersonRoles(List<PersonRole> personRoles) {
        this.personRoles = personRoles;
    }

    public PersonRole addPersonRole(PersonRole personRole) {
        getPersonRoles().add(personRole);
        personRole.setLocation(this);

        return personRole;
    }

    public PersonRole removePersonRole(PersonRole personRole) {
        getPersonRoles().remove(personRole);
        personRole.setLocation(null);

        return personRole;
    }
}
