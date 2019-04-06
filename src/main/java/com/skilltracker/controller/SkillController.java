package com.skilltracker.controller;

import com.skilltracker.model.Skill;
import com.skilltracker.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/skills")
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping(path = "")
    public ResponseEntity<List<Skill>> getSkills(){
        List<Skill> skills = skillService.getSkillsByType();
        if(skills.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Skill>>(skills,HttpStatus.OK);
    }
}
