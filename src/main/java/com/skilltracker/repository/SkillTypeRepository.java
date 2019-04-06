package com.skilltracker.repository;

import com.skilltracker.model.Skill;
import com.skilltracker.model.SkillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTypeRepository extends JpaRepository<SkillType, Long> {

}
