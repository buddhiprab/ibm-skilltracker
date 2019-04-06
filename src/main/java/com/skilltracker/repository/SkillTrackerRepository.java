package com.skilltracker.repository;

import com.skilltracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillTrackerRepository extends JpaRepository<User, Long> {
}
