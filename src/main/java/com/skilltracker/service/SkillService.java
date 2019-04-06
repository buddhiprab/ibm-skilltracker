package com.skilltracker.service;

import com.skilltracker.model.Skill;
import com.skilltracker.model.SkillType;
import com.skilltracker.repository.SkillRepository;
import com.skilltracker.repository.SkillTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    SkillTypeRepository skillTypeRepository;

    public List<Skill> getSkillsByType(Long skillTypeId){
        return skillRepository.findBySkillTypeId(skillTypeId);
    }

    public List<SkillType> getAll(){
        return skillTypeRepository.findAll();
    }
}
