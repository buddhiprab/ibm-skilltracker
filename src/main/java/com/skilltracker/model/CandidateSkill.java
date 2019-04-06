package com.skilltracker.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "candidateSkill")
public class CandidateSkill {


    private int id;

    private int candidateId;

    private int skillId;

    private int skillExperienceId;

    private int skillUsageId;

    private boolean certified;


}