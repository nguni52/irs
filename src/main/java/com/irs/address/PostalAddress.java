package com.irs.address;

import com.irs.assetmanager.AssetManager;
import com.irs.employee.Employee;
import com.irs.investor.Investor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
/**
 *
 * @author Kenneth.Maposa
 */

@Entity
@Table(name = "postal_address")
public class PostalAddress {
    @Id
    @Column(name = "postal_address_id")
    @GeneratedValue
    private Integer postalAddressID;
    @Column(name = "number")
    private int number;
    @Column(name = "suburb")
    private String suburb;
    @Column(name = "postal_code")
    private int postalCode;
    @Column(name = "status")
    private int status;    
    @OneToOne
    @PrimaryKeyJoinColumn
    AssetManager assetManager;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Investor investor;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Employee employee;
    
    public Integer getPostalAddressID() {
        return postalAddressID;
    }

    public void setpostalAddressID(Integer postalAddressID) {
        this.postalAddressID = postalAddressID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
    
      public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
