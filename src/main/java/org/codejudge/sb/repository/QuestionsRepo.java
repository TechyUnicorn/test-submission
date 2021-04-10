package org.codejudge.sb.repository;


import org.codejudge.sb.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Integer> {
    @Query(value = "select id,name,description from QuizQuestions where id=:id ",nativeQuery = true)
    public Map findById(@Param("id") Integer id);

    public void save(Map quiz);

    public Questions findQuestionsByQuiz(Integer quizId);
}