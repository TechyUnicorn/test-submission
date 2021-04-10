package org.codejudge.sb.service;

import java.util.Map;

public interface QuizQuestionsService {

    public Map getQuizById(Integer id);

    public void saveOrUpdateQuiz(Map quiz);

    public Map getQestionById(Integer id);

    public void saveOrUpdateQuestion(Map question);

    public Map getAllQuestionsForQuizId(int quizId);
}
