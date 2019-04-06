package com.skilltracker.service;

import com.skilltracker.dto.SkillDto;
import com.skilltracker.model.Skill;
import com.skilltracker.model.SkillType;

import java.util.List;

public interface SkillService {

     List<SkillDto> getAllSkills();

    List<Skill> getSkillsByType(int skillTypeId);
    List<SkillType> getAll();

}
