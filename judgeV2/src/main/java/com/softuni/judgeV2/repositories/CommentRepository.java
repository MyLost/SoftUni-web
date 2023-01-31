package com.softuni.judgeV2.repositories;

import com.softuni.judgeV2.models.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    @Query("SELECT AVG(c.score) FROM CommentEntity c")
    Double findAvgScore();
}
