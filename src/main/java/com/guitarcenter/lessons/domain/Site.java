package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;

/**
 * The persistent class for the SITE database table.
 *
 */
@Entity
@NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
public class Site implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SITE_ID")
    private long siteId;

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    private String name;

    private Object updated;

    private String url;

    @Column(name = "\"VERSION\"")
    private BigDecimal version;

    //bi-directional many-to-one association to Activity
    @OneToMany(mappedBy = "site")
    private List<Activity> activities;

    //bi-directional many-to-one association to Appointment
    @OneToMany(mappedBy = "site")
    private List<Appointment> appointments;

    //bi-directional many-to-one association to AppointmentCancelReason
    @OneToMany(mappedBy = "site")
    private List<AppointmentCancelReason> appointmentCancelReasons;

    //bi-directional many-to-one association to AppointmentSery
    @OneToMany(mappedBy = "site")
    private List<AppointmentSery> appointmentSeries;

    //bi-directional many-to-one association to Availability
    @OneToMany(mappedBy = "site")
    private List<Availability> availabilities;

    //bi-directional many-to-one association to Customer
    @OneToMany(mappedBy = "site")
    private List<Customer> customers;

    //bi-directional many-to-one association to CustomerStatus
    @OneToMany(mappedBy = "site")
    private List<CustomerStatus> customerStatuses;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy = "site")
    private List<Employee> employees;

    //bi-directional many-to-one association to Instructor
    @OneToMany(mappedBy = "site")
    private List<Instructor> instructors;

    //bi-directional many-to-one association to Instrument
    @OneToMany(mappedBy = "site")
    private List<Instrument> instruments;

    //bi-directional many-to-one association to Location
    @OneToMany(mappedBy = "site")
    private List<Location> locations;

    //bi-directional many-to-one association to LocationProfile
    @OneToMany(mappedBy = "site")
    private List<LocationProfile> locationProfiles;

    //bi-directional many-to-one association to PersonPersonalDetail
    @OneToMany(mappedBy = "site")
    private List<PersonPersonalDetail> personPersonalDetails;

    //bi-directional many-to-one association to PersonRole
    @OneToMany(mappedBy = "site")
    private List<PersonRole> personRoles;

    //bi-directional many-to-one association to ProfileActivity
    @OneToMany(mappedBy = "site")
    private List<ProfileActivity> profileActivities;

    //bi-directional many-to-one association to ProfileService
    @OneToMany(mappedBy = "site")
    private List<ProfileService> profileServices;

    //bi-directional many-to-one association to Role
    @OneToMany(mappedBy = "site")
    private List<Role> roles;

    //bi-directional many-to-one association to Room
    @OneToMany(mappedBy = "site")
    private List<Room> rooms;

    //bi-directional many-to-one association to RoomNumber
    @OneToMany(mappedBy = "site")
    private List<RoomNumber> roomNumbers;

    //bi-directional many-to-one association to RoomSize
    @OneToMany(mappedBy = "site")
    private List<RoomSize> roomSizes;

    //bi-directional many-to-one association to RoomTemplate
    @OneToMany(mappedBy = "site")
    private List<RoomTemplate> roomTemplates;

    //bi-directional many-to-one association to RoomType
    @OneToMany(mappedBy = "site")
    private List<RoomType> roomTypes;

    //bi-directional many-to-one association to Service
    @OneToMany(mappedBy = "site")
    private List<Service> services;

    //bi-directional many-to-one association to Person
    @ManyToOne
    @JoinColumn(name = "UPDATED_BY")
    private Person person;

    public Site() {}

    public long getSiteId() {
        return this.siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getUpdated() {
        return this.updated;
    }

    public void setUpdated(Object updated) {
        this.updated = updated;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        activity.setSite(this);

        return activity;
    }

    public Activity removeActivity(Activity activity) {
        getActivities().remove(activity);
        activity.setSite(null);

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
        appointment.setSite(this);

        return appointment;
    }

    public Appointment removeAppointment(Appointment appointment) {
        getAppointments().remove(appointment);
        appointment.setSite(null);

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
        appointmentCancelReason.setSite(this);

        return appointmentCancelReason;
    }

    public AppointmentCancelReason removeAppointmentCancelReason(AppointmentCancelReason appointmentCancelReason) {
        getAppointmentCancelReasons().remove(appointmentCancelReason);
        appointmentCancelReason.setSite(null);

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
        appointmentSery.setSite(this);

        return appointmentSery;
    }

    public AppointmentSery removeAppointmentSery(AppointmentSery appointmentSery) {
        getAppointmentSeries().remove(appointmentSery);
        appointmentSery.setSite(null);

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
        availability.setSite(this);

        return availability;
    }

    public Availability removeAvailability(Availability availability) {
        getAvailabilities().remove(availability);
        availability.setSite(null);

        return availability;
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer addCustomer(Customer customer) {
        getCustomers().add(customer);
        customer.setSite(this);

        return customer;
    }

    public Customer removeCustomer(Customer customer) {
        getCustomers().remove(customer);
        customer.setSite(null);

        return customer;
    }

    public List<CustomerStatus> getCustomerStatuses() {
        return this.customerStatuses;
    }

    public void setCustomerStatuses(List<CustomerStatus> customerStatuses) {
        this.customerStatuses = customerStatuses;
    }

    public CustomerStatus addCustomerStatus(CustomerStatus customerStatus) {
        getCustomerStatuses().add(customerStatus);
        customerStatus.setSite(this);

        return customerStatus;
    }

    public CustomerStatus removeCustomerStatus(CustomerStatus customerStatus) {
        getCustomerStatuses().remove(customerStatus);
        customerStatus.setSite(null);

        return customerStatus;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee addEmployee(Employee employee) {
        getEmployees().add(employee);
        employee.setSite(this);

        return employee;
    }

    public Employee removeEmployee(Employee employee) {
        getEmployees().remove(employee);
        employee.setSite(null);

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
        instructor.setSite(this);

        return instructor;
    }

    public Instructor removeInstructor(Instructor instructor) {
        getInstructors().remove(instructor);
        instructor.setSite(null);

        return instructor;
    }

    public List<Instrument> getInstruments() {
        return this.instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public Instrument addInstrument(Instrument instrument) {
        getInstruments().add(instrument);
        instrument.setSite(this);

        return instrument;
    }

    public Instrument removeInstrument(Instrument instrument) {
        getInstruments().remove(instrument);
        instrument.setSite(null);

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
        location.setSite(this);

        return location;
    }

    public Location removeLocation(Location location) {
        getLocations().remove(location);
        location.setSite(null);

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
        locationProfile.setSite(this);

        return locationProfile;
    }

    public LocationProfile removeLocationProfile(LocationProfile locationProfile) {
        getLocationProfiles().remove(locationProfile);
        locationProfile.setSite(null);

        return locationProfile;
    }

    public List<PersonPersonalDetail> getPersonPersonalDetails() {
        return this.personPersonalDetails;
    }

    public void setPersonPersonalDetails(List<PersonPersonalDetail> personPersonalDetails) {
        this.personPersonalDetails = personPersonalDetails;
    }

    public PersonPersonalDetail addPersonPersonalDetail(PersonPersonalDetail personPersonalDetail) {
        getPersonPersonalDetails().add(personPersonalDetail);
        personPersonalDetail.setSite(this);

        return personPersonalDetail;
    }

    public PersonPersonalDetail removePersonPersonalDetail(PersonPersonalDetail personPersonalDetail) {
        getPersonPersonalDetails().remove(personPersonalDetail);
        personPersonalDetail.setSite(null);

        return personPersonalDetail;
    }

    public List<PersonRole> getPersonRoles() {
        return this.personRoles;
    }

    public void setPersonRoles(List<PersonRole> personRoles) {
        this.personRoles = personRoles;
    }

    public PersonRole addPersonRole(PersonRole personRole) {
        getPersonRoles().add(personRole);
        personRole.setSite(this);

        return personRole;
    }

    public PersonRole removePersonRole(PersonRole personRole) {
        getPersonRoles().remove(personRole);
        personRole.setSite(null);

        return personRole;
    }

    public List<ProfileActivity> getProfileActivities() {
        return this.profileActivities;
    }

    public void setProfileActivities(List<ProfileActivity> profileActivities) {
        this.profileActivities = profileActivities;
    }

    public ProfileActivity addProfileActivity(ProfileActivity profileActivity) {
        getProfileActivities().add(profileActivity);
        profileActivity.setSite(this);

        return profileActivity;
    }

    public ProfileActivity removeProfileActivity(ProfileActivity profileActivity) {
        getProfileActivities().remove(profileActivity);
        profileActivity.setSite(null);

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
        profileService.setSite(this);

        return profileService;
    }

    public ProfileService removeProfileService(ProfileService profileService) {
        getProfileServices().remove(profileService);
        profileService.setSite(null);

        return profileService;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role addRole(Role role) {
        getRoles().add(role);
        role.setSite(this);

        return role;
    }

    public Role removeRole(Role role) {
        getRoles().remove(role);
        role.setSite(null);

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
        room.setSite(this);

        return room;
    }

    public Room removeRoom(Room room) {
        getRooms().remove(room);
        room.setSite(null);

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
        roomNumber.setSite(this);

        return roomNumber;
    }

    public RoomNumber removeRoomNumber(RoomNumber roomNumber) {
        getRoomNumbers().remove(roomNumber);
        roomNumber.setSite(null);

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
        roomSize.setSite(this);

        return roomSize;
    }

    public RoomSize removeRoomSize(RoomSize roomSize) {
        getRoomSizes().remove(roomSize);
        roomSize.setSite(null);

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
        roomTemplate.setSite(this);

        return roomTemplate;
    }

    public RoomTemplate removeRoomTemplate(RoomTemplate roomTemplate) {
        getRoomTemplates().remove(roomTemplate);
        roomTemplate.setSite(null);

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
        roomType.setSite(this);

        return roomType;
    }

    public RoomType removeRoomType(RoomType roomType) {
        getRoomTypes().remove(roomType);
        roomType.setSite(null);

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
        service.setSite(this);

        return service;
    }

    public Service removeService(Service service) {
        getServices().remove(service);
        service.setSite(null);

        return service;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
