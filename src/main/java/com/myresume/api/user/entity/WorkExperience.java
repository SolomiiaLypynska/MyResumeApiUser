package com.myresume.api.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "WORK_EXPERIENCE")
@SequenceGenerator(name = "SEQ_WORK_EXPERIENCE",
        sequenceName = "SEQ_WORK_EXPERIENCE",
        initialValue = 1,
        allocationSize = 1)
public class WorkExperience {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_WORK_EXPERIENCE"
    )
    @Column(name = "WORK_EXPERIENCE_ID")
    private Long workExperienceId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "USERS_ID", referencedColumnName = "ID")
    private User user;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "POSITION_TITLE")
    private String positionTitle;
    @Column(name = "EMPLOYMENT_TYPE")
    private String employmentType;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TOOL_AND_TECHNOLOGY")
    private String toolAndTechnology;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CITY")
    private String city;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;
    @Column(name = "CREATED_ON", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdOn;
    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;
}
