package com.softuni.judgeV2.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="homeworks")
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkEntity extends BaseEntity {

    @Column(name="added_on")
    private LocalDateTime addedOn;
    @Column(name="git_address")
    private String gitAddress;
    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private ExerciseEntity exercise;

    @OneToMany(mappedBy = "homework", fetch = FetchType.EAGER)
    private Set<CommentEntity> comments;


}
