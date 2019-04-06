package com.skilltracker.service.impl;

import com.skilltracker.dto.SkillDto;
import com.skilltracker.model.Skill;
import com.skilltracker.model.SkillType;
import com.skilltracker.repository.SkillRepository;
import com.skilltracker.repository.SkillTypeRepository;
import com.skilltracker.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {


    @Autowired
    SkillRepository skillRepository;

    @Autowired
    SkillTypeRepository skillTypeRepository;

    public List<Skill> getSkillsByType(int skillTypeId){
        return skillRepository.findBySkillTypeId(skillTypeId);
    }

    @Override
    public List<SkillType> getAll(){
        return skillTypeRepository.findAll();
    }

    @Override
    public List<SkillDto> getAllSkills() {


        List<SkillDto> allSkills = skillRepository.findAll().stream().map(this::transformEntityToDto).collect(Collectors.toList());


        return allSkills;
    }


    private SkillDto transformEntityToDto(Skill skill){
        SkillDto skillDto = SkillDto.builder()
                .skillId(skill.getId())
                .skillTitle(skill.getTitle())
                .skillTypeTitle(skill.getSkillType().getTitle()).build();
        return skillDto;
    }


}
