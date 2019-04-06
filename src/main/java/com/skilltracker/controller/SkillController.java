package com.skilltracker.controller;

import com.skilltracker.dto.SkillDto;
import com.skilltracker.model.CandidateSkill;
import com.skilltracker.model.Skill;
import com.skilltracker.model.SkillType;
import com.skilltracker.repository.CandidateRepository;
import com.skilltracker.service.SkillService;
import com.skilltracker.service.SkillTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

import java.util.List;

@RestController
@RequestMapping(path = "/skills")
public class SkillController {

    @Autowired
    SkillService skillService;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    SkillTypeService skillTypeService;


    @GetMapping("/")
    public ResponseEntity<List<SkillDto>> getAllSkills() {

        List<SkillDto> skills = skillService.getAllSkills();
        if (skills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<SkillDto>>(skills, HttpStatus.OK);
    }


    //Author - Buddhi
    @GetMapping("/{skillTypeId}")
    public ResponseEntity<List<Skill>> getSkills(@PathVariable int skillTypeId) {

        List<Skill> skills = skillService.getSkillsByType(skillTypeId);
        if (skills.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Skill>>(skills, HttpStatus.OK);
    }

    //Author -- RameshKumar
    @GetMapping(path = "/getSkillTypes")
    public List<SkillType> getSkillTypes() {
        List<SkillType> skillType = skillTypeService.getAllSkillTypes();
        if (null != skillType) {
            return skillType;
        } else {
            throw new RestClientException("Skill Type Doesn't Found");
        }
    }

    //Author -RameshKumar
    @PostMapping(value = "/saveSkillTracker", produces = "application/json")
    public ResponseEntity saveSkillTracker(@RequestParam Integer candidateId, @RequestParam Integer skillId,
                                           @RequestParam Integer skillExperienceId, @RequestParam Integer skillUsageId, @RequestParam boolean certified) {
        if (candidateId != null && skillId != null && skillExperienceId != null && skillUsageId != null) {
            CandidateSkill candidateSkill = new CandidateSkill();
            candidateSkill.setCandidateId(candidateId);
            candidateSkill.setSkillId(skillId);
            candidateSkill.setSkillExperienceId(skillExperienceId);
            candidateSkill.setSkillUsageId(skillUsageId);
            candidateRepository.save(candidateSkill);
        } else {
            throw new RestClientException("All the requeried Id need to available to save the Candidate Skills");
        }
        return ResponseEntity.ok().build();
    }

}

