package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the PERSON database table.
 *
 */
@Entity
@NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    private long personId;

    @Column(name = "AUTH_ID")
    private String authId;

    private String email;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    private String phone;

    private Object updated;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Activity
    @OneToMany(mappedBy = "person")
    private List<Activity> activities;

    //bi-directional many-to-one association to Appointment
    @OneToMany(mappedBy = "person")
    private List<Appointment> appointments;

    //bi-directional many-to-one association to AppointmentCancelReason
    @OneToMany(mappedBy = "person")
    private List<AppointmentCancelReason> appointmentCancelReasons;

    //bi-directional many-to-one association to AppointmentSery
    @OneToMany(mappedBy = "person")
    private List<AppointmentSery> appointmentSeries;

    //bi-directional many-to-one association to Availability
    @OneToMany(mappedBy = "person")
    private List<Availability> availabilities;

    //bi-directional many-to-one association to Customer
    @OneToMany(mappedBy = "person1")
    private List<Customer> customers1;

    //bi-directional many-to-one association to Customer
    @OneToMany(mappedBy = "person2")
    private List<Customer> customers2;

    //bi-directional many-to-one association to CustomerStatus
    @OneToMany(mappedBy = "person")
    private List<CustomerStatus> customerStatuses;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "person1")
    private List<Employee> employees1;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "person2")
    private List<Employee> employees2;

    //bi-directional many-to-one association to Instructor
    @OneToMany(mappedBy = "person1")
    private List<Instructor> instructors1;

    //bi-directional many-to-one association to Instructor
    @OneToMany(mappedBy = "person2")
    private List<Instructor> instructors2;

    //bi-directional many-to-one association to Instrument
    @OneToMany(mappedBy = "person")
    private List<Instrument> instruments;

    //bi-directional many-to-one association to Location
    @OneToMany(mappedBy = "person")
    private List<Location> locations;

    //bi-directional many-to-one association to LocationProfile
    @OneToMany(mappedBy = "person")
    private List<LocationProfile> locationProfiles;

    //bi-directional many-to-one association to ParentDetail
    @OneToMany(mappedBy = "person")
    private List<ParentDetail> parentDetails;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    //bi-directional many-to-one association to Person
    @OneToMany(mappedBy = "person")
    private List<Person> persons;

    //bi-directional one-to-one association to PersonPersonalDetail
    @OneToOne(mappedBy = "person1")
    private PersonPersonalDetail personPersonalDetail;

    //bi-directional many-to-one association to PersonPersonalDetail
    @OneToMany(mappedBy = "person2")
    private List<PersonPersonalDetail> personPersonalDetails;

    //bi-directional many-to-one association to PersonRole
    @OneToMany(mappedBy = "person1")
    private List<PersonRole> personRoles1;

    //bi-directional many-to-one association to PersonRole
    @OneToMany(mappedBy = "person2")
    private List<PersonRole> personRoles2;

    //bi-directional many-to-one association to ProfileActivity
    @OneToMany(mappedBy = "person")
    private List<ProfileActivity> profileActivities;

    //bi-directional many-to-one association to ProfileService
    @OneToMany(mappedBy = "person")
    private List<ProfileService> profileServices;

    //bi-directional many-to-one association to ProfileTimeoff
    @OneToMany(mappedBy = "person")
    private List<ProfileTimeoff> profileTimeoffs;

    //bi-directional many-to-one association to Role
    @OneToMany(mappedBy = "person")
    private List<Role> roles;

    //bi-directional many-to-one association to Room
    @OneToMany(mappedBy = "person")
    private List<Room> rooms;

    //bi-directional many-to-one association to RoomNumber
    @OneToMany(mappedBy = "person")
    private List<RoomNumber> roomNumbers;

    //bi-directional many-to-one association to RoomSize
    @OneToMany(mappedBy = "person")
    private List<RoomSize> roomSizes;

    //bi-directional many-to-one association to RoomTemplate
    @OneToMany(mappedBy = "person")
    private List<RoomTemplate> roomTemplates;

    //bi-directional many-to-one association to RoomType
    @OneToMany(mappedBy = "person")
    private List<RoomType> roomTypes;

    //bi-directional many-to-one association to Service
    @OneToMany(mappedBy = "person")
    private List<Service> services;

    //bi-directional many-to-one association to Site
    @OneToMany(mappedBy = "person")
    private List<Site> sites;

    //bi-directional many-to-one association to UserLog
    @OneToMany(mappedBy = "person")
    private List<UserLog> userLogs;

    public Person() {}

    public long getPersonId() {
        return this.personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getAuthId() {
        return this.authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public List<Activity> getActivities() {
        return this.activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public Activity addActivity(Activity activity) {
        getActivities().add(activity);
        activity.setPerson(this);

        return activity;
    }

    public Activity removeActivity(Activity activity) {
        getActivities().remove(activity);
        activity.setPerson(null);

        return activity;
    }

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Appointment addAppointment(Appointment appointment) {
        getAppointments().add(appointment);
        appointment.setPerson(this);

        return appointment;
    }

    public Appointment removeAppointment(Appointment appointment) {
        getAppointments().remove(appointment);
        appointment.setPerson(null);

        return appointment;
    }

    public List<AppointmentCancelReason> getAppointmentCancelReasons() {
        return this.appointmentCancelReasons;
    }

    public void setAppointmentCancelReasons(List<AppointmentCancelReason> appointmentCancelReasons) {
        this.appointmentCancelReasons = appointmentCancelReasons;
    }

    public AppointmentCancelReason addAppointmentCancelReason(AppointmentCancelReason appointmentCancelReason) {
        getAppointmentCancelReasons().add(appointmentCancelReason);
        appointmentCancelReason.setPerson(this);

        return appointmentCancelReason;
    }

    public AppointmentCancelReason removeAppointmentCancelReason(AppointmentCancelReason appointmentCancelReason) {
        getAppointmentCancelReasons().remove(appointmentCancelReason);
        appointmentCancelReason.setPerson(null);

        return appointmentCancelReason;
    }

    public List<AppointmentSery> getAppointmentSeries() {
        return this.appointmentSeries;
    }

    public void setAppointmentSeries(List<AppointmentSery> appointmentSeries) {
        this.appointmentSeries = appointmentSeries;
    }

    public AppointmentSery addAppointmentSery(AppointmentSery appointmentSery) {
        getAppointmentSeries().add(appointmentSery);
        appointmentSery.setPerson(this);

        return appointmentSery;
    }

    public AppointmentSery removeAppointmentSery(AppointmentSery appointmentSery) {
        getAppointmentSeries().remove(appointmentSery);
        appointmentSery.setPerson(null);

        return appointmentSery;
    }

    public List<Availability> getAvailabilities() {
        return this.availabilities;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }

    public Availability addAvailability(Availability availability) {
        getAvailabilities().add(availability);
        availability.setPerson(this);

        return availability;
    }

    public Availability removeAvailability(Availability availability) {
        getAvailabilities().remove(availability);
        availability.setPerson(null);

        return availability;
    }

    public List<Customer> getCustomers1() {
        return this.customers1;
    }

    public void setCustomers1(List<Customer> customers1) {
        this.customers1 = customers1;
    }

    public Customer addCustomers1(Customer customers1) {
        getCustomers1().add(customers1);
        customers1.setPerson1(this);

        return customers1;
    }

    public Customer removeCustomers1(Customer customers1) {
        getCustomers1().remove(customers1);
        customers1.setPerson1(null);

        return customers1;
    }

    public List<Customer> getCustomers2() {
        return this.customers2;
    }

    public void setCustomers2(List<Customer> customers2) {
        this.customers2 = customers2;
    }

    public Customer addCustomers2(Customer customers2) {
        getCustomers2().add(customers2);
        customers2.setPerson2(this);

        return customers2;
    }

    public Customer removeCustomers2(Customer customers2) {
        getCustomers2().remove(customers2);
        customers2.setPerson2(null);

        return customers2;
    }

    public List<CustomerStatus> getCustomerStatuses() {
        return this.customerStatuses;
    }

    public void setCustomerStatuses(List<CustomerStatus> customerStatuses) {
        this.customerStatuses = customerStatuses;
    }

    public CustomerStatus addCustomerStatus(CustomerStatus customerStatus) {
        getCustomerStatuses().add(customerStatus);
        customerStatus.setPerson(this);

        return customerStatus;
    }

    public CustomerStatus removeCustomerStatus(CustomerStatus customerStatus) {
        getCustomerStatuses().remove(customerStatus);
        customerStatus.setPerson(null);

        return customerStatus;
    }

    public List<Employee> getEmployees1() {
        return this.employees1;
    }

    public void setEmployees1(List<Employee> employees1) {
        this.employees1 = employees1;
    }

    public Employee addEmployees1(Employee employees1) {
        getEmployees1().add(employees1);
        employees1.setPerson1(this);

        return employees1;
    }

    public Employee removeEmployees1(Employee employees1) {
        getEmployees1().remove(employees1);
        employees1.setPerson1(null);

        return employees1;
    }

    public List<Employee> getEmployees2() {
        return this.employees2;
    }

    public void setEmployees2(List<Employee> employees2) {
        this.employees2 = employees2;
    }

    public Employee addEmployees2(Employee employees2) {
        getEmployees2().add(employees2);
        employees2.setPerson2(this);

        return employees2;
    }

    public Employee removeEmployees2(Employee employees2) {
        getEmployees2().remove(employees2);
        employees2.setPerson2(null);

        return employees2;
    }

    public List<Instructor> getInstructors1() {
        return this.instructors1;
    }

    public void setInstructors1(List<Instructor> instructors1) {
        this.instructors1 = instructors1;
    }

    public Instructor addInstructors1(Instructor instructors1) {
        getInstructors1().add(instructors1);
        instructors1.setPerson1(this);

        return instructors1;
    }

    public Instructor removeInstructors1(Instructor instructors1) {
        getInstructors1().remove(instructors1);
        instructors1.setPerson1(null);

        return instructors1;
    }

    public List<Instructor> getInstructors2() {
        return this.instructors2;
    }

    public void setInstructors2(List<Instructor> instructors2) {
        this.instructors2 = instructors2;
    }

    public Instructor addInstructors2(Instructor instructors2) {
        getInstructors2().add(instructors2);
        instructors2.setPerson2(this);

        return instructors2;
    }

    public Instructor removeInstructors2(Instructor instructors2) {
        getInstructors2().remove(instructors2);
        instructors2.setPerson2(null);

        return instructors2;
    }

    public List<Instrument> getInstruments() {
        return this.instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public Instrument addInstrument(Instrument instrument) {
        getInstruments().add(instrument);
        instrument.setPerson(this);

        return instrument;
    }

    public Instrument removeInstrument(Instrument instrument) {
        getInstruments().remove(instrument);
        instrument.setPerson(null);

        return instrument;
    }

    public List<Location> getLocations() {
        return this.locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Location addLocation(Location location) {
        getLocations().add(location);
        location.setPerson(this);

        return location;
    }

    public Location removeLocation(Location location) {
        getLocations().remove(location);
        location.setPerson(null);

        return location;
    }

    public List<LocationProfile> getLocationProfiles() {
        return this.locationProfiles;
    }

    public void setLocationProfiles(List<LocationProfile> locationProfiles) {
        this.locationProfiles = locationProfiles;
    }

    public LocationProfile addLocationProfile(LocationProfile locationProfile) {
        getLocationProfiles().add(locationProfile);
        locationProfile.setPerson(this);

        return locationProfile;
    }

    public LocationProfile removeLocationProfile(LocationProfile locationProfile) {
        getLocationProfiles().remove(locationProfile);
        locationProfile.setPerson(null);

        return locationProfile;
    }

    public List<ParentDetail> getParentDetails() {
        return this.parentDetails;
    }

    public void setParentDetails(List<ParentDetail> parentDetails) {
        this.parentDetails = parentDetails;
    }

    public ParentDetail addParentDetail(ParentDetail parentDetail) {
        getParentDetails().add(parentDetail);
        parentDetail.setPerson(this);

        return parentDetail;
    }

    public ParentDetail removeParentDetail(ParentDetail parentDetail) {
        getParentDetails().remove(parentDetail);
        parentDetail.setPerson(null);

        return parentDetail;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersons() {
        return this.persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public Person addPerson(Person person) {
        getPersons().add(person);
        person.setPerson(this);

        return person;
    }

    public Person removePerson(Person person) {
        getPersons().remove(person);
        person.setPerson(null);

        return person;
    }

    public PersonPersonalDetail getPersonPersonalDetail() {
        return this.personPersonalDetail;
    }

    public void setPersonPersonalDetail(PersonPersonalDetail personPersonalDetail) {
        this.personPersonalDetail = personPersonalDetail;
    }

    public List<PersonPersonalDetail> getPersonPersonalDetails() {
        return this.personPersonalDetails;
    }

    public void setPersonPersonalDetails(List<PersonPersonalDetail> personPersonalDetails) {
        this.personPersonalDetails = personPersonalDetails;
    }

    public PersonPersonalDetail addPersonPersonalDetail(PersonPersonalDetail personPersonalDetail) {
        getPersonPersonalDetails().add(personPersonalDetail);
        personPersonalDetail.setPerson2(this);

        return personPersonalDetail;
    }

    public PersonPersonalDetail removePersonPersonalDetail(PersonPersonalDetail personPersonalDetail) {
        getPersonPersonalDetails().remove(personPersonalDetail);
        personPersonalDetail.setPerson2(null);

        return personPersonalDetail;
    }

    public List<PersonRole> getPersonRoles1() {
        return this.personRoles1;
    }

    public void setPersonRoles1(List<PersonRole> personRoles1) {
        this.personRoles1 = personRoles1;
    }

    public PersonRole addPersonRoles1(PersonRole personRoles1) {
        getPersonRoles1().add(personRoles1);
        personRoles1.setPerson1(this);

        return personRoles1;
    }

    public PersonRole removePersonRoles1(PersonRole personRoles1) {
        getPersonRoles1().remove(personRoles1);
        personRoles1.setPerson1(null);

        return personRoles1;
    }

    public List<PersonRole> getPersonRoles2() {
        return this.personRoles2;
    }

    public void setPersonRoles2(List<PersonRole> personRoles2) {
        this.personRoles2 = personRoles2;
    }

    public PersonRole addPersonRoles2(PersonRole personRoles2) {
        getPersonRoles2().add(personRoles2);
        personRoles2.setPerson2(this);

        return personRoles2;
    }

    public PersonRole removePersonRoles2(PersonRole personRoles2) {
        getPersonRoles2().remove(personRoles2);
        personRoles2.setPerson2(null);

        return personRoles2;
    }

    public List<ProfileActivity> getProfileActivities() {
        return this.profileActivities;
    }

    public void setProfileActivities(List<ProfileActivity> profileActivities) {
        this.profileActivities = profileActivities;
    }

    public ProfileActivity addProfileActivity(ProfileActivity profileActivity) {
        getProfileActivities().add(profileActivity);
        profileActivity.setPerson(this);

        return profileActivity;
    }

    public ProfileActivity removeProfileActivity(ProfileActivity profileActivity) {
        getProfileActivities().remove(profileActivity);
        profileActivity.setPerson(null);

        return profileActivity;
    }

    public List<ProfileService> getProfileServices() {
        return this.profileServices;
    }

    public void setProfileServices(List<ProfileService> profileServices) {
        this.profileServices = profileServices;
    }

    public ProfileService addProfileService(ProfileService profileService) {
        getProfileServices().add(profileService);
        profileService.setPerson(this);

        return profileService;
    }

    public ProfileService removeProfileService(ProfileService profileService) {
        getProfileServices().remove(profileService);
        profileService.setPerson(null);

        return profileService;
    }

    public List<ProfileTimeoff> getProfileTimeoffs() {
        return this.profileTimeoffs;
    }

    public void setProfileTimeoffs(List<ProfileTimeoff> profileTimeoffs) {
        this.profileTimeoffs = profileTimeoffs;
    }

    public ProfileTimeoff addProfileTimeoff(ProfileTimeoff profileTimeoff) {
        getProfileTimeoffs().add(profileTimeoff);
        profileTimeoff.setPerson(this);

        return profileTimeoff;
    }

    public ProfileTimeoff removeProfileTimeoff(ProfileTimeoff profileTimeoff) {
        getProfileTimeoffs().remove(profileTimeoff);
        profileTimeoff.setPerson(null);

        return profileTimeoff;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role addRole(Role role) {
        getRoles().add(role);
        role.setPerson(this);

        return role;
    }

    public Role removeRole(Role role) {
        getRoles().remove(role);
        role.setPerson(null);

        return role;
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room addRoom(Room room) {
        getRooms().add(room);
        room.setPerson(this);

        return room;
    }

    public Room removeRoom(Room room) {
        getRooms().remove(room);
        room.setPerson(null);

        return room;
    }

    public List<RoomNumber> getRoomNumbers() {
        return this.roomNumbers;
    }

    public void setRoomNumbers(List<RoomNumber> roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public RoomNumber addRoomNumber(RoomNumber roomNumber) {
        getRoomNumbers().add(roomNumber);
        roomNumber.setPerson(this);

        return roomNumber;
    }

    public RoomNumber removeRoomNumber(RoomNumber roomNumber) {
        getRoomNumbers().remove(roomNumber);
        roomNumber.setPerson(null);

        return roomNumber;
    }

    public List<RoomSize> getRoomSizes() {
        return this.roomSizes;
    }

    public void setRoomSizes(List<RoomSize> roomSizes) {
        this.roomSizes = roomSizes;
    }

    public RoomSize addRoomSize(RoomSize roomSize) {
        getRoomSizes().add(roomSize);
        roomSize.setPerson(this);

        return roomSize;
    }

    public RoomSize removeRoomSize(RoomSize roomSize) {
        getRoomSizes().remove(roomSize);
        roomSize.setPerson(null);

        return roomSize;
    }

    public List<RoomTemplate> getRoomTemplates() {
        return this.roomTemplates;
    }

    public void setRoomTemplates(List<RoomTemplate> roomTemplates) {
        this.roomTemplates = roomTemplates;
    }

    public RoomTemplate addRoomTemplate(RoomTemplate roomTemplate) {
        getRoomTemplates().add(roomTemplate);
        roomTemplate.setPerson(this);

        return roomTemplate;
    }

    public RoomTemplate removeRoomTemplate(RoomTemplate roomTemplate) {
        getRoomTemplates().remove(roomTemplate);
        roomTemplate.setPerson(null);

        return roomTemplate;
    }

    public List<RoomType> getRoomTypes() {
        return this.roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }

    public RoomType addRoomType(RoomType roomType) {
        getRoomTypes().add(roomType);
        roomType.setPerson(this);

        return roomType;
    }

    public RoomType removeRoomType(RoomType roomType) {
        getRoomTypes().remove(roomType);
        roomType.setPerson(null);

        return roomType;
    }

    public List<Service> getServices() {
        return this.services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Service addService(Service service) {
        getServices().add(service);
        service.setPerson(this);

        return service;
    }

    public Service removeService(Service service) {
        getServices().remove(service);
        service.setPerson(null);

        return service;
    }

    public List<Site> getSites() {
        return this.sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public Site addSite(Site site) {
        getSites().add(site);
        site.setPerson(this);

        return site;
    }

    public Site removeSite(Site site) {
        getSites().remove(site);
        site.setPerson(null);

        return site;
    }

    public List<UserLog> getUserLogs() {
        return this.userLogs;
    }

    public void setUserLogs(List<UserLog> userLogs) {
        this.userLogs = userLogs;
    }

    public UserLog addUserLog(UserLog userLog) {
        getUserLogs().add(userLog);
        userLog.setPerson(this);

        return userLog;
    }

    public UserLog removeUserLog(UserLog userLog) {
        getUserLogs().remove(userLog);
        userLog.setPerson(null);

        return userLog;
    }
}
