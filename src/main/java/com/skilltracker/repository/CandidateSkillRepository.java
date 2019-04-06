package com.skilltracker.repository;

import com.skilltracker.model.Candidate;
import com.skilltracker.model.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, Integer> {
    public List<CandidateSkill> findByCandidate(Candidate candidate);
}
