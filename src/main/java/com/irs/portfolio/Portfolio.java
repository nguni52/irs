/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irs.portfolio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Kenneth.Maposa
 */
@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @Column(name = "portfolio_id")
    @GeneratedValue
    private Integer portfolioID;
    @Column(name = "portfolio_description")
    private String portfolioDescription;

    public Integer getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(Integer portfolioID) {
        this.portfolioID = portfolioID;
    }

    public String getPortfolioDescription() {
        return portfolioDescription;
    }

    public void setPortfolioDescription(String portfolioDescription) {
        this.portfolioDescription = portfolioDescription;
    }        
}
