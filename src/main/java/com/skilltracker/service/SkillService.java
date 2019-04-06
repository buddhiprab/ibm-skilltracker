package com.skilltracker.service;

import com.skilltracker.model.Skill;
import com.skilltracker.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    SkillRepository skillRepository;

    public List<Skill> getSkillsByType(Long skillTypeId){
        return skillRepository.findBySkillTypeId(skillTypeId);
    }
}
