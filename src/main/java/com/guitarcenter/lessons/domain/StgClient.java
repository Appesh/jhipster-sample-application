package com.guitarcenter.lessons.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the STG_CLIENTS database table.
 *
 */
@Entity
@Table(name = "STG_CLIENTS")
@NamedQuery(name = "StgClient.findAll", query = "SELECT s FROM StgClient s")
public class StgClient implements Serializable {
    private static final long serialVersionUID = 1L;

    private String address1;

    private String address2;

    private String applytimezone;

    private String billingaddress1;

    private String billingaddress2;

    private String billingcity;

    private String billingcountryname;

    private String billingpostalcode;

    private String billingstatename;

    private String birthdate;

    private String city;

    private String company;

    private String contactmethod;

    private String countryname;

    private String createdate;

    private String createdbyuserfirstname;

    private String createdbyuserid;

    private String createdbyuserlastname;

    private String creditcardnumber;

    @Column(name = "CUSTOM_FIELD_1")
    private String customField1;

    @Column(name = "CUSTOM_FIELD_10")
    private String customField10;

    @Column(name = "CUSTOM_FIELD_2")
    private String customField2;

    @Column(name = "CUSTOM_FIELD_3")
    private String customField3;

    @Column(name = "CUSTOM_FIELD_4")
    private String customField4;

    @Column(name = "CUSTOM_FIELD_5")
    private String customField5;

    @Column(name = "CUSTOM_FIELD_6")
    private String customField6;

    @Column(name = "CUSTOM_FIELD_7")
    private String customField7;

    @Column(name = "CUSTOM_FIELD_8")
    private String customField8;

    @Column(name = "CUSTOM_FIELD_9")
    private String customField9;

    private String customerid;

    private String customername;

    @Column(name = "D_ISSPECIALPROMOTIONSENABLED")
    private String dIsspecialpromotionsenabled;

    private String emailaddress;

    private String externalid;

    private String faxphone;

    private String firstname;

    private String gender;

    private String homephone;

    private String isemailenabled;

    private String jobtitle;

    private String lastname;

    private String licenseeid;

    private String memberid;

    private String mobilephone;

    private String postalcode;

    private String rulesgroupid;

    private String rulesgroupname;

    private String salutation;

    private String ssn;

    private String statename;

    private String timezone;

    private String usergroupid;

    private String usergroupname;

    private String userid;

    private String username;

    private String userscomment;

    private String workphone;

    public StgClient() {}

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

    public String getApplytimezone() {
        return this.applytimezone;
    }

    public void setApplytimezone(String applytimezone) {
        this.applytimezone = applytimezone;
    }

    public String getBillingaddress1() {
        return this.billingaddress1;
    }

    public void setBillingaddress1(String billingaddress1) {
        this.billingaddress1 = billingaddress1;
    }

    public String getBillingaddress2() {
        return this.billingaddress2;
    }

    public void setBillingaddress2(String billingaddress2) {
        this.billingaddress2 = billingaddress2;
    }

    public String getBillingcity() {
        return this.billingcity;
    }

    public void setBillingcity(String billingcity) {
        this.billingcity = billingcity;
    }

    public String getBillingcountryname() {
        return this.billingcountryname;
    }

    public void setBillingcountryname(String billingcountryname) {
        this.billingcountryname = billingcountryname;
    }

    public String getBillingpostalcode() {
        return this.billingpostalcode;
    }

    public void setBillingpostalcode(String billingpostalcode) {
        this.billingpostalcode = billingpostalcode;
    }

    public String getBillingstatename() {
        return this.billingstatename;
    }

    public void setBillingstatename(String billingstatename) {
        this.billingstatename = billingstatename;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContactmethod() {
        return this.contactmethod;
    }

    public void setContactmethod(String contactmethod) {
        this.contactmethod = contactmethod;
    }

    public String getCountryname() {
        return this.countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreatedbyuserfirstname() {
        return this.createdbyuserfirstname;
    }

    public void setCreatedbyuserfirstname(String createdbyuserfirstname) {
        this.createdbyuserfirstname = createdbyuserfirstname;
    }

    public String getCreatedbyuserid() {
        return this.createdbyuserid;
    }

    public void setCreatedbyuserid(String createdbyuserid) {
        this.createdbyuserid = createdbyuserid;
    }

    public String getCreatedbyuserlastname() {
        return this.createdbyuserlastname;
    }

    public void setCreatedbyuserlastname(String createdbyuserlastname) {
        this.createdbyuserlastname = createdbyuserlastname;
    }

    public String getCreditcardnumber() {
        return this.creditcardnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public String getCustomField1() {
        return this.customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField10() {
        return this.customField10;
    }

    public void setCustomField10(String customField10) {
        this.customField10 = customField10;
    }

    public String getCustomField2() {
        return this.customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField3() {
        return this.customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getCustomField4() {
        return this.customField4;
    }

    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    public String getCustomField5() {
        return this.customField5;
    }

    public void setCustomField5(String customField5) {
        this.customField5 = customField5;
    }

    public String getCustomField6() {
        return this.customField6;
    }

    public void setCustomField6(String customField6) {
        this.customField6 = customField6;
    }

    public String getCustomField7() {
        return this.customField7;
    }

    public void setCustomField7(String customField7) {
        this.customField7 = customField7;
    }

    public String getCustomField8() {
        return this.customField8;
    }

    public void setCustomField8(String customField8) {
        this.customField8 = customField8;
    }

    public String getCustomField9() {
        return this.customField9;
    }

    public void setCustomField9(String customField9) {
        this.customField9 = customField9;
    }

    public String getCustomerid() {
        return this.customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return this.customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getDIsspecialpromotionsenabled() {
        return this.dIsspecialpromotionsenabled;
    }

    public void setDIsspecialpromotionsenabled(String dIsspecialpromotionsenabled) {
        this.dIsspecialpromotionsenabled = dIsspecialpromotionsenabled;
    }

    public String getEmailaddress() {
        return this.emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getExternalid() {
        return this.externalid;
    }

    public void setExternalid(String externalid) {
        this.externalid = externalid;
    }

    public String getFaxphone() {
        return this.faxphone;
    }

    public void setFaxphone(String faxphone) {
        this.faxphone = faxphone;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomephone() {
        return this.homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getIsemailenabled() {
        return this.isemailenabled;
    }

    public void setIsemailenabled(String isemailenabled) {
        this.isemailenabled = isemailenabled;
    }

    public String getJobtitle() {
        return this.jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLicenseeid() {
        return this.licenseeid;
    }

    public void setLicenseeid(String licenseeid) {
        this.licenseeid = licenseeid;
    }

    public String getMemberid() {
        return this.memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getMobilephone() {
        return this.mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getPostalcode() {
        return this.postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getRulesgroupid() {
        return this.rulesgroupid;
    }

    public void setRulesgroupid(String rulesgroupid) {
        this.rulesgroupid = rulesgroupid;
    }

    public String getRulesgroupname() {
        return this.rulesgroupname;
    }

    public void setRulesgroupname(String rulesgroupname) {
        this.rulesgroupname = rulesgroupname;
    }

    public String getSalutation() {
        return this.salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getSsn() {
        return this.ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getStatename() {
        return this.statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getUsergroupid() {
        return this.usergroupid;
    }

    public void setUsergroupid(String usergroupid) {
        this.usergroupid = usergroupid;
    }

    public String getUsergroupname() {
        return this.usergroupname;
    }

    public void setUsergroupname(String usergroupname) {
        this.usergroupname = usergroupname;
    }

    public String getUserid() {
        return this.userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserscomment() {
        return this.userscomment;
    }

    public void setUserscomment(String userscomment) {
        this.userscomment = userscomment;
    }

    public String getWorkphone() {
        return this.workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }
}
