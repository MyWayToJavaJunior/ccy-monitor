package com.golubov.rest;

import com.golubov.model.CcyEntity;
import com.golubov.repo.CcyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SGolubov on 7/28/2015.
 */
@RestController
public class CcyMonitorController {

    @Autowired
    private CcyRepository ccyRepository;

    @RequestMapping(value = "rates")
    public List<CcyEntity> getAllrates() {
        return ccyRepository.findAll();
    }



}
