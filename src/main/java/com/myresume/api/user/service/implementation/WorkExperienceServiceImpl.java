package com.myresume.api.user.service.implementation;

import com.myresume.api.user.dto.WorkExperienceRequestDto;
import com.myresume.api.user.dto.WorkExperienceResponseDto;
import com.myresume.api.user.entity.User;
import com.myresume.api.user.entity.WorkExperience;
import com.myresume.api.user.exception.exceptionType.NotFoundException;
import com.myresume.api.user.mapper.WorkExperienceRequestMapper;
import com.myresume.api.user.mapper.WorkExperienceResponseMapper;
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
    private WorkExperienceResponseMapper workExperienceResponseMapper;
    @Autowired
    private WorkExperienceRequestMapper workExperienceRequestMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public WorkExperienceRequestDto addWorkExperience(WorkExperienceRequestDto dto) {
        WorkExperience workExperience = workExperienceRequestMapper.toEntity(dto);
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new NotFoundException("Not found WorkExperience by id: " + dto.getUserId()));
        workExperience.setUser(user);
        workExperienceRepository.save(workExperience);
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
}
