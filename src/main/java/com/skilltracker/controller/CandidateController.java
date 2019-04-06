package com.skilltracker.controller;


import com.skilltracker.model.CandidateSkill;
import com.skilltracker.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {
    @Autowired
    CandidateRepository candidateRepository;

    //Author -RameshKumar
    @PostMapping(value = "/saveSkill", produces = "application/json")
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
