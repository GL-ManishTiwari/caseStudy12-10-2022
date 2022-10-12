package com.springboot.sampleprj.repository;

import com.springboot.sampleprj.model.*;
import org.springframework.data.repository.CrudRepository;

public interface ShareRepository extends CrudRepository<CompanyShare, Integer> {

}
