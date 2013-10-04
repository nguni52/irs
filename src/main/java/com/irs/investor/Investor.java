package com.irs.investor;

import com.irs.address.PhysicalAddress;
import com.irs.address.PostalAddress;
import com.irs.person.Person;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author bmqolweni
 */
@Entity
@Table(name = "investor")
public class Investor {

    @Id
    @Column(name = "investor_id")
    @GeneratedValue
    private Integer investorID;
    @Column(name = "investor_description")
    private String investorDescription;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "email_address")
    private String emailAddress;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "investor_person", joinColumns = @JoinColumn( name = "investor_id"), inverseJoinColumns = @JoinColumn( name = "person_id"))
    private Set<Person> person;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "investor_physical_address", joinColumns = @JoinColumn( name = "investor_id"), inverseJoinColumns = @JoinColumn( name = "physical_address_id"))
    private Set<PhysicalAddress> physicalAddress;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "investor_postal_address", joinColumns = @JoinColumn( name = "investor_id"), inverseJoinColumns = @JoinColumn( name = "postal_address_id"))
    private Set<PostalAddress> postalAddress;
    
    public Integer getInvestorID() {
        return investorID;
    }

    public void setInvestorID(Integer investorID) {
        this.investorID = investorID;
    }

    public String getInvestorDescription() {
        return investorDescription;
    }

    public void setInvestorDescription(String investorDescription) {
        this.investorDescription = investorDescription;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<PhysicalAddress> getPhysicalAddress() {
        return physicalAddress;
    }

    public void setPhysicalAddress(Set<PhysicalAddress> physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public Set<PostalAddress> getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(Set<PostalAddress> postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }
}

