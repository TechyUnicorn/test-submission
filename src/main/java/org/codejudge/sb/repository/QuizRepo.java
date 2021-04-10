package org.codejudge.sb.repository;

import org.codejudge.sb.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

    @Query(value = "SELECT ID,NAME,DESCRIPTION FROM QUIZ WHERE ID=:id ", nativeQuery = true)
    public Map findById(@Param("id") Integer id);

    public void save(Map quiz);

    public String findNameById(Integer quizId);

    public String findDescriptionById(Integer quizId);
}


