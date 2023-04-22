package com.myresume.api.user.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
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
    private Long id;
    @Column(name = "FIRST_NAME", length = 60)
    private String firstName;
    @Column(name = "LAST_NAME", length = 60)
    private String lastName;
    @Column(name = "PASSWORD", nullable = false, length = 250)
    private String password;
    @Column(name = "EMAIL", nullable = false, length = 250, unique = true)
    private String email;
}
