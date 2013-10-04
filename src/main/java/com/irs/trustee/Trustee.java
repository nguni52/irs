package com.irs.trustee;

import com.irs.person.Person;
import com.irs.person.Title;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Kenneth.Maposa
 */

@Entity
@Table(name = "trustee")
public class Trustee implements Serializable {
    @Id
    @Column(name = "trustee_id")
    @GeneratedValue
    private Integer trusteeId;
    @Column(name="investor_id")
    private Integer investorId;
    @Column(name="trustee_role_id")
    private Integer trusteeRoleId;
    @Column(name="date_from")
    private String dateFrom;
    @Column(name="date_to")
    private String dateTo;
    @Column(name="status")
    private Integer status;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="person_id")
    private Person person;
    
    public Integer getTrusteeId() {
        return trusteeId;
    }

    public void setTrusteeId(Integer trusteeId) {
        this.trusteeId = trusteeId;
    }

    public Integer getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Integer investorId) {
        this.investorId = investorId;
    }
    
    /*public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getPersonId() {
        return personId;
    }*/

    public Integer getTrusteeRoleId() {
        return trusteeRoleId;
    }

    public void setTrusteeRoleId(Integer trusteeRoleId) {
        this.trusteeRoleId = trusteeRoleId;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    @Override
    public String toString() {
        return "Trustee{" + "trusteeId=" + trusteeId + ", investorId=" + investorId 
                + ", trusteeRoleId=" + trusteeRoleId + ", dateFrom=" + dateFrom 
                + ", dateTo=" + dateTo + ", status=" + status + '}';
    } 
}
