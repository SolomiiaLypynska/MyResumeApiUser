package com.myresume.api.user.repository;

import com.myresume.api.user.entity.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {
}
