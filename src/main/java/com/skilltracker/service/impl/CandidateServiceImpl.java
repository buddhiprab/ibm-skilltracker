package com.skilltracker.service.impl;

import com.skilltracker.model.Candidate;
import com.skilltracker.model.CandidateSkill;
import com.skilltracker.repository.CandidateRepository;
import com.skilltracker.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {


    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public Candidate getCandidate(int candidateId) {
        return candidateRepository.getOne(candidateId);
    }

    @Override
    public Candidate saveCandidateSkills(CandidateSkill candidateSkill) {
        return null;
    }
}
