package com.skilltracker.service.impl;

import com.skilltracker.dto.SkillDto;
import com.skilltracker.model.Skill;
import com.skilltracker.model.SkillType;
import com.skilltracker.repository.SkillRepository;
import com.skilltracker.repository.SkillTypeRepository;
import com.skilltracker.service.SkillService;
import com.skilltracker.service.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillTypeServiceImpl implements SkillTypeService {


    @Autowired
    SkillTypeRepository skillTypeRepository;


    @Override
    public List<SkillType> getAllSkillTypes() {
        return skillTypeRepository.findAll();
    }
}
