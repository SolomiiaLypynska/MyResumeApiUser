package com.myresume.api.user.controller;

import com.myresume.api.user.dto.WorkExperienceDto;
import com.myresume.api.user.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/work/experience")
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService workExperienceService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WorkExperienceDto> addExperience(@Valid @RequestBody WorkExperienceDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workExperienceService.addWorkExperience(dto));
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WorkExperienceDto> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(workExperienceService.getWorkExperienceById(id));
    }
}
