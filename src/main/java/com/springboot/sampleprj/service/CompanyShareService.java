package com.springboot.sampleprj.service;

import java.util.List;

import com.springboot.sampleprj.model.*;

public interface CompanyShareService {
    public List<CompanyShare> getAllCompanyShares();

    public CompanyShare getCompanyShareById(int id);

    public void addCompanyShare(CompanyShare cmpshare);

    public void deleteCompanyShare(int id);
}
