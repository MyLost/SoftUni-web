package com.softuni.judgeV2.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(name="username", unique = true, nullable = false)
    private String username;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="email", unique = true, nullable = false)
    private String email;
    @Column(name="git")
    private String git;

    @ManyToOne
    private RoleEntity role;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<HomeworkEntity> homeworkSet;

}
