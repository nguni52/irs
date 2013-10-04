package com.irs.user;

import com.irs.address.PostalAddress;
import com.irs.person.Person;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author nkululekophakela
 * 
 * //
 *   @JoinColumn(name="username")
 */
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements Serializable {
    /*@Id
     * @GeneratedValue
     */
    @Column(name = "user_id")
    private int userID;    
    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="enabled")
    private int enabled;
    @Column(name="password_expired")
    private int passwordExpired;   
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Authority authority;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_person", joinColumns = @JoinColumn( name = "username"), inverseJoinColumns = @JoinColumn( name = "person_id"))
    private Set<Person> person;    
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public int getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(int passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }

    /*
     * + "userID=" + userID 
     * 
     */
    @Override
    public String toString() {
        return "User{" + ", username=" + username 
                + ", password=" + password + ", enabled=" + enabled 
                + ", passwordExpired=" + passwordExpired 
                + ", authority=" + authority + ", person=" + person + '}';
    }
}
