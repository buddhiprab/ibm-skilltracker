package com.skilltracker.service;

import com.skilltracker.model.Candidate;
import com.skilltracker.model.CandidateSkill;

public interface CandidateService {

    Candidate getCandidate(int candidateId);

    Candidate saveCandidateSkills(CandidateSkill candidateSkill);

}
