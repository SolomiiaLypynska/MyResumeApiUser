package com.myresume.api.user.service.implementation;

import com.myresume.api.user.dto.WorkExperienceRequestDto;
import com.myresume.api.user.dto.WorkExperienceResponseDto;
import com.myresume.api.user.entity.User;
import com.myresume.api.user.entity.WorkExperience;
import com.myresume.api.user.exception.exception_type.NotFoundException;
import com.myresume.api.user.mapper.WorkExperienceRequestMapper;
import com.myresume.api.user.mapper.WorkExperienceResponseMapper;
import com.myresume.api.user.repository.UserRepository;
import com.myresume.api.user.repository.WorkExperienceRepository;
import com.myresume.api.user.service.WorkExperienceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

    @Autowired
    private WorkExperienceRepository workExperienceRepository;
    @Autowired
    private WorkExperienceResponseMapper workExperienceResponseMapper;
    @Autowired
    private WorkExperienceRequestMapper workExperienceRequestMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public WorkExperienceRequestDto addWorkExperience(WorkExperienceRequestDto dto) {
        log.info("Started create new WorkExperience: {};", dto);
        WorkExperience workExperience = workExperienceRequestMapper.toEntity(dto);
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NotFoundException("Not found User by id: " + dto.getUserId()));
        workExperience.setUser(user);
        workExperienceRepository.save(workExperience);
        log.info("Successfully created new WorkExperience;");
        return dto;
    }

    @Override
    public WorkExperienceResponseDto getWorkExperienceById(Long id) {
        WorkExperience workExperience = workExperienceRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found WorkExperience by id: " + id));
        return workExperienceResponseMapper.toDto(workExperience);
    }

    @Override
    public void deleteWorkExperienceById(Long id) {
        workExperienceRepository.deleteById(id);
    }

    @Override
    public WorkExperienceRequestDto updateWorkExperience(Long id, WorkExperienceRequestDto dto) {
        log.info("Started updating WorkExperience by id: {};", id);
        WorkExperience workExperience = workExperienceRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found WorkExperience by id: " + id));
        workExperience.setCompanyName(dto.getCompanyName());
        workExperience.setPositionTitle(dto.getPositionTitle());
        workExperience.setEmploymentType(dto.getEmploymentType());
        workExperience.setDescription(dto.getDescription());
        workExperience.setToolAndTechnology(dto.getToolAndTechnology());
        workExperience.setCountry(dto.getCountry());
        workExperience.setCity(dto.getCity());
        workExperience.setStartDate(dto.getStartDate());
        workExperience.setEndDate(dto.getEndDate());

        workExperienceRepository.save(workExperience);
        log.info("Successfully update WorkExperience;");
        return workExperienceRequestMapper.toDto(workExperience);
    }
}
