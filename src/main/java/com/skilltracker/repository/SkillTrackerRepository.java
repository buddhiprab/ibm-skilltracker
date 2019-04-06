package com.skilltracker.repository;

import com.skilltracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillTrackerRepository extends JpaRepository<User, Long> { 
}
