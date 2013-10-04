package com.irs.assetmanager;

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
 * @author Kenneth.Maposa
 */
@Entity
@Table(name = "asset_manager")
public class AssetManager {

    @Id
    @Column(name = "asset_manager_id")
    @GeneratedValue
    private Integer assetManagerID;
    @Column(name = "asset_manager_description")
    private String assetManagerDescription;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "email_address")
    private String emailAddress;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "asset_manager_person", joinColumns = @JoinColumn( name = "asset_manager_id"), inverseJoinColumns = @JoinColumn( name = "person_id"))
    private Set<Person> person;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "asset_manager_physical_address", joinColumns = @JoinColumn( name = "asset_manager_id"), inverseJoinColumns = @JoinColumn( name = "physical_address_id"))
    private Set<PhysicalAddress> physicalAddress;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "asset_manager_postal_address", joinColumns = @JoinColumn( name = "asset_manager_id"), inverseJoinColumns = @JoinColumn( name = "postal_address_id"))
    private Set<PostalAddress> postalAddress;
    
    public Integer getAssetManagerID() {
        return assetManagerID;
    }

    public void setAssetManagerID(Integer assetManagerID) {
        this.assetManagerID = assetManagerID;
    }

    public String getAssetManagerDescription() {
        return assetManagerDescription;
    }

    public void setAssetManagerDescription(String assetManagerDescription) {
        this.assetManagerDescription = assetManagerDescription;
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
