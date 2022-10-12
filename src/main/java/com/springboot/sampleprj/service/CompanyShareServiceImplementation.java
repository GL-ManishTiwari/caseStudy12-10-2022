package com.springboot.sampleprj.service;

import com.springboot.sampleprj.model.*;
import com.springboot.sampleprj.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CompanyShareServiceImplementation implements CompanyShareService {

    @Autowired
    ShareRepository shareRepository;

    @Override
    public List<CompanyShare> getAllCompanyShares() {
        return (List<CompanyShare>) shareRepository.findAll();
    }

    @Override
    public CompanyShare getCompanyShareById(int id) {
        return shareRepository.findById(id).get();
    }

    @Override
    public void addCompanyShare(CompanyShare cmpShare) {
        shareRepository.save(cmpShare);
    }

    @Override
    public void deleteCompanyShare(int id) {
        shareRepository.deleteById(id);
    }

}
