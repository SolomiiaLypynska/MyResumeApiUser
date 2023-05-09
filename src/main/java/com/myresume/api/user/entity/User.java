package com.myresume.api.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "SEQ_USERS",
        sequenceName = "SEQ_USERS",
        initialValue = 1,
        allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USERS"
    )
    @Column(name = "ID")
    private Long userId;
    @Column(name = "FIRST_NAME", length = 60)
    private String firstName;
    @Column(name = "LAST_NAME", length = 60)
    private String lastName;
    @Column(name = "PASSWORD", nullable = false, length = 250)
    private String password;
    @Column(name = "EMAIL", nullable = false, length = 250, unique = true)
    private String email;
    @Column(name = "ROLE", nullable = false, length = 60)
    private String role;
    @Column(name = "ACTIVE", nullable = false, columnDefinition = "NUMBER DEFAULT 1")
    private Long active;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<WorkExperience> workExperience;
    @Column(name = "CREATED_ON", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdOn;
    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;
}
