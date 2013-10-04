package com.irs.trusteerole;

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
 * @author lutendo
 */
@Entity
@Table(name = "trustee_role")
public class TrusteeRole {

    @Id
    @Column(name = "trustee_role_id")
    @GeneratedValue
    private Integer trusteeRoleID;
    @Column(name = "trustee_role_description")
    private String trusteeRoleDescription;
    /*@Column(name = "contact_number")
     private String contactNumber;
     @Column(name = "email_address")
     private String emailAddress;
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "trustee_person", joinColumns =
    @JoinColumn( name = "trustee_role_id"), inverseJoinColumns =
    @JoinColumn( name = "person_id"))
    private Set<Person> person;

    /* @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JoinTable(name = "investor_physical_address", joinColumns = @JoinColumn( name = "investor_id"), inverseJoinColumns = @JoinColumn( name = "physical_address_id"))
     private Set<PhysicalAddress> physicalAddress;
    
     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
     @JoinTable(name = "investor_postal_address", joinColumns = @JoinColumn( name = "investor_id"), inverseJoinColumns = @JoinColumn( name = "postal_address_id"))
     private Set<PostalAddress> postalAddress;
     */
    public Integer getTrusteeRoleID() {
        return trusteeRoleID;
    }

    public void setTrusteeRoleID(Integer trusteeRoleID) {
        this.trusteeRoleID = trusteeRoleID;
    }

    public String getTrusteeRoleDescription() {
        return trusteeRoleDescription;
    }

    public void setTrusteeRoleDescription(String trusteeRoleDescription) {
        this.trusteeRoleDescription = trusteeRoleDescription;
    }

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }
}






/*

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

**
 *
 * @author lutendo
 *
@Entity
@Table(name = "trustee_role")
public class TrusteeRole {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Column(name="description")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
*/
