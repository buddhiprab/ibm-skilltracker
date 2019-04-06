package com.skilltracker.service.impl;

import com.skilltracker.model.Candidate;
import com.skilltracker.model.CandidateSkill;
import com.skilltracker.repository.CandidateRepository;
import com.skilltracker.repository.CandidateSkillRepository;
import com.skilltracker.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    CandidateSkillRepository candidateSkillRepository;

    @Override
    @Transactional
    public Candidate getCandidate(int candidateId) {
        return candidateRepository.getOne(candidateId);
    }

    @Override
    public Candidate saveCandidateSkills(CandidateSkill candidateSkill) {
        return null;
    }

    @Override
    public List<CandidateSkill> getCandidateSkills(Candidate candidate) {
        return candidateSkillRepository.findByCandidate(candidate);
    }
}
