package com.irs.person;

import com.irs.assetmanager.AssetManager;
import com.irs.employee.Employee;
import com.irs.investor.Investor;
import com.irs.trustee.Trustee;
import com.irs.user.User;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author nguni52
 */
@Entity
@Table(name = "person", uniqueConstraints = {@UniqueConstraint(columnNames = {"person_id"})})
public class Person implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="person_id")
    private Integer personId;
    @Column(name="job_title")
    private String jobTitle;
    @Column(name="gender")
    private String gender;
    @Column(name="identity_number")
    private String identityNumber;
    @Column(name="firstname")
    private String firstname;
    @Column(name="surname")
    private String surname;
    @Column(name="work_number")
    private String workNumber;
    @Column(name="mobile_number")
    private String mobileNumber;
    @Column(name="email_address")
    private String emailAddress;
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="title_id")
    private Title title;
    @OneToOne
    @PrimaryKeyJoinColumn
    private AssetManager assetManager;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Investor investor;
    @OneToOne(mappedBy="person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Trustee trustee;
    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
    /*@OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Employee employee;*/


    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
    
    /*public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/
    
    
    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }


    public void setTrustee(Trustee trustee) {
       this.trustee = trustee;
    }
    
    public Trustee getTrustee() {
        return this.trustee;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
