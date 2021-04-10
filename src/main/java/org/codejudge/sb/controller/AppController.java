package org.codejudge.sb.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;
import org.codejudge.sb.service.QuizQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
public class AppController {

    @Autowired
    QuizQuestionsService quizQuestionsService;

    @JsonIgnore
    @GetMapping(value="/quiz/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getQuiz(@PathVariable Integer id) {
        return quizQuestionsService.getQuizById(id);
    }

    @PostMapping(value = "/quiz",consumes = MediaType.APPLICATION_JSON_VALUE)
    private void createQuiz(@RequestBody Map quiz)  {
        log.info(quiz.toString());
        quizQuestionsService.saveOrUpdateQuiz(quiz);
    }


    @GetMapping("/questions/{id}")
    public Map getQuestion(@PathVariable Integer id) {
        return quizQuestionsService.getQestionById(id);
    }

    @PostMapping(value = "/questions",consumes = MediaType.APPLICATION_JSON_VALUE)
    private void createQuestion(@RequestBody Map question) {
        quizQuestionsService.saveOrUpdateQuestion(question);
    }

    @GetMapping("/quiz-questions/{id}")
    public Map getAllQuestionsForQuizId(@PathVariable Integer quizId) {
        return quizQuestionsService.getAllQuestionsForQuizId(quizId);
    }

}