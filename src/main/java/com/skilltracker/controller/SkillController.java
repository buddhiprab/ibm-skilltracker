package com.skilltracker.controller;

import com.skilltracker.dto.SkillDto;
import com.skilltracker.model.Skill;
import com.skilltracker.model.SkillType;
import com.skilltracker.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
@RequestMapping(path = "/skills")
public class SkillController {
    @Autowired
    SkillService skillService;



    @GetMapping(path = "/{skillType}")
    public ResponseEntity<List<Skill>> getSkills(@PathVariable Long skillTypeId){
        List<Skill> skills = skillService.getSkillsByType(skillTypeId);
        if(skills.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Skill>>(skills,HttpStatus.OK);
    }

    //Author -- RameshKumar
    @GetMapping(value = "/getSkillType")
    public List<SkillType> getSkillType() {
        List<SkillType> skillType = skillService.getAll();
        if (null != skillType) {
            return skillType;
        } else {
            throw new RestClientException("Skill Type Doesn't Found");
        }
    }



    @GetMapping(path = "/{skillType}")
    public ResponseEntity<List<SkillDto>> getAllSkills(){
        List<SkillDto> skills = skillService.getAllSkills();
        if(skills.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<SkillDto>>(skills,HttpStatus.OK);
    }
}
