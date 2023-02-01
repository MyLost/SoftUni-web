package com.softuni.judgeV2.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="exercises")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseEntity extends BaseEntity {

    @Column(name="name")
    private String name;

    @Column(name="started_on")
    private LocalDateTime startedOn;

    @Column(name="due_date")
    private LocalDateTime dueDate;

}
