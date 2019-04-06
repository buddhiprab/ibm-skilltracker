package com.skilltracker.service;

import com.skilltracker.model.Candidate;
import com.skilltracker.model.CandidateSkill;

import java.util.List;

public interface CandidateService {

    Candidate getCandidate(int candidateId);

    Candidate saveCandidateSkills(CandidateSkill candidateSkill);

    List<CandidateSkill> getCandidateSkills(Candidate candidate);
}
