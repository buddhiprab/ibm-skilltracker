package com.skilltracker.controller;


import com.skilltracker.dto.CandidateSkillDto;
import com.skilltracker.model.*;
import com.skilltracker.repository.*;
import com.skilltracker.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;

@RestController
@RequestMapping(path = "/candidate")
public class CandidateController {


    @Autowired
    CandidateService candidateService;


    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    SkillExperienceRepository skillExperienceRepository;
    @Autowired
    SkillUsageRepository skillUsageRepository;
    @Autowired
    CandidateSkillRepository candidateSkillRepository;

    //Author -RameshKumar
    @PostMapping(value = "/saveSkill", produces = "application/json")
    public ResponseEntity saveSkillTracker(@RequestBody CandidateSkillDto candidateSkillDto) {
        Integer candidateId = candidateSkillDto.getCandidateId();
        Integer skillId = candidateSkillDto.getSkillId();
        Integer skillExperienceId = candidateSkillDto.getSkillExperienceId();
        Integer skillUsageId = candidateSkillDto.getSkillUsageId();
        boolean certified = candidateSkillDto.isCertified();
        if (candidateId != 0 && skillId != 0 && skillExperienceId != 0 && skillUsageId != 0) {
            Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
            Skill skill = skillRepository.findById(skillId).orElse(null);
            SkillExperience skillExperience = skillExperienceRepository.findById(skillExperienceId).orElse(null);
            SkillUsage skillUsage = skillUsageRepository.findById(skillUsageId).orElse(null);

            CandidateSkill candidateSkill = CandidateSkill.builder()
                    .candidate(candidate)
                    .skill(skill)
                    .skillExperience(skillExperience)
                    .skillUsage(skillUsage)
                    .certified(certified).build();

            candidateSkillRepository.save(candidateSkill);
        } else {
            throw new RestClientException("All the requeried Id need to available to save the Candidate Skills");
        }
        return ResponseEntity.ok().build();
    }



    @GetMapping("/{candidateId}")
    public Candidate getCandidate(@PathVariable Integer candidateId){
        if (null != candidateId) {
            return candidateService.getCandidate(candidateId);
        } else {
            throw new RestClientException("Skill Type Doesn't Found");
        }

    }


}
