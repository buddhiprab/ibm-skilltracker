package com.skilltracker.repository;

import com.skilltracker.model.Candidate;
import com.skilltracker.model.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateSkill, Integer> {
}
