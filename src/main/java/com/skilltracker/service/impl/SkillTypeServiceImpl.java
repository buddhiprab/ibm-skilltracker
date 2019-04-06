package com.skilltracker.service.impl;

import com.skilltracker.model.SkillType;
import com.skilltracker.repository.SkillTypeRepository;
import com.skilltracker.service.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillTypeServiceImpl implements SkillTypeService {


    @Autowired
    private SkillTypeRepository skillTypeRepository;


    @Override
    public List<SkillType> getAllSkillTypes() {
        return skillTypeRepository.findAll();
    }

}
