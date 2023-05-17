package com.myresume.api.user.service.implementation;

import com.myresume.api.user.dto.WorkExperienceDto;
import com.myresume.api.user.entity.User;
import com.myresume.api.user.entity.WorkExperience;
import com.myresume.api.user.exception.exceptionType.NotFoundException;
import com.myresume.api.user.mapper.WorkExperienceMapper;
import com.myresume.api.user.repository.UserRepository;
import com.myresume.api.user.repository.WorkExperienceRepository;
import com.myresume.api.user.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

    @Autowired
    private WorkExperienceRepository workExperienceRepository;
    @Autowired
    private WorkExperienceMapper workExperienceMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public WorkExperienceDto addWorkExperience(WorkExperienceDto dto) {
        WorkExperience workExperience = workExperienceMapper.toEntity(dto);
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NotFoundException("Not found WorkExperience by id: " + dto.getUserId()));
        workExperience.setUser(user);
        workExperienceRepository.save(workExperience);
        return dto;
    }

    @Override
    public WorkExperienceDto getWorkExperienceById(Long id) {
        WorkExperience workExperience = workExperienceRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found WorkExperience by id: " + id));
        return workExperienceMapper.toDto(workExperience);
    }
}
