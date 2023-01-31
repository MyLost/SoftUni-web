package com.softuni.judgeV2.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="comments")
@Getter
@Setter
public class CommentEntity extends BaseEntity {

    private Integer score;
    private String textContent;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private HomeworkEntity homework;
}
