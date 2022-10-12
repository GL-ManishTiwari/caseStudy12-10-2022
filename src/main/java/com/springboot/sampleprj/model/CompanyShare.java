package com.springboot.sampleprj.model;

import javax.persistence.*;

// @Data
@Entity
@Table(name = "company_share")
public class CompanyShare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "share_price")
    private double sharePrice;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(double sharePrice) {
        this.sharePrice = sharePrice;
    }
}
