package com.skilltracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CandidateSkillDto {
    private int candidateId;
    private int skillId;
    private int skillExperienceId;
    private int skillUsageId;
    private boolean certified;
}
