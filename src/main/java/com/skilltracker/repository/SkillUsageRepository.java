package com.skilltracker.repository;

import com.skilltracker.model.SkillUsage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillUsageRepository extends JpaRepository<SkillUsage, Integer> {
}
