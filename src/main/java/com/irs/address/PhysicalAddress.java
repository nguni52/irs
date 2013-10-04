package com.irs.address;

import com.irs.assetmanager.AssetManager;
import com.irs.employee.Employee;
import com.irs.investor.Investor;
import java.io.Serializable;
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
@Table(name = "physical_address")
public class PhysicalAddress implements Serializable{
    @Id
    @Column(name = "physical_address_id")
    @GeneratedValue
    private Integer physicalAddressID;
    @Column(name = "unit_number")
    private int unitNumber;
    @Column(name = "complex_name")
    private String complexName;
    @Column(name = "street_number")
    private int streetNumber;
    @Column(name="street_name")
    private String streetName;
    @Column(name = "suburb")
    private String suburb;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private int postalCode;
    @Column(name = "status")
    private int status;
    @OneToOne
    @PrimaryKeyJoinColumn
    private AssetManager assetManager;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Investor investor;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Employee employee;
    

    public Integer getPhysicalAddressID() {
        return physicalAddressID;
    }

    public void setPhysicalAddressID(Integer physicalAddressID) {
        this.physicalAddressID = physicalAddressID;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    @Override
    public String toString() {
        return "PhysicalAddress{" + "physicalAddressID=" + physicalAddressID + ", unitNumber=" + unitNumber + ", complexName=" + complexName + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", suburb=" + suburb + ", city=" + city + ", postalCode=" + postalCode + ", status=" + status + ", assetManager=" + assetManager + ", investor=" + investor + '}';
    } 
}
