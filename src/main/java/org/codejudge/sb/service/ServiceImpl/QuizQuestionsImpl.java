package org.codejudge.sb.service.ServiceImpl;

import org.codejudge.sb.model.Questions;
import org.codejudge.sb.repository.QuestionsRepo;
import org.codejudge.sb.repository.QuizRepo;
import org.codejudge.sb.service.QuizQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class QuizQuestionsImpl implements QuizQuestionsService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionsRepo questionsRepo;

    Map fail = null;

    public Map getQuizById(Integer id) {
        Map quiz = new HashMap<>();
        try {
            quiz = quizRepo.findById(id.intValue());
            return quiz.size() > 0 ? quiz : new HashMap();
        } catch (Exception e) {
            fail = new HashMap();
            fail.put("status", "failure");
            fail.put("reason", e);
            return fail;
        }
    }

    public void saveOrUpdateQuiz(Map quiz) {
        try {
            quizRepo.save(quiz);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Map getQestionById(Integer id) {
        Map question = new HashMap<>();
        try {
            question = questionsRepo.findById(id);
            return question.size() > 0 ? question : new HashMap();
        } catch (Exception e) {
            fail = new HashMap();
            fail.put("status", "failure");
            fail.put("reason", e);
            return fail;
        }
    }

    public void saveOrUpdateQuestion(Map question) {
        try {
            questionsRepo.save(question);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Map getAllQuestionsForQuizId(int quizId) {
        try {
            Map result = new HashMap();
            String name = quizRepo.findNameById(quizId);
            String description = quizRepo.findDescriptionById(quizId);
            Questions questions = questionsRepo.findQuestionsByQuiz(quizId);

            result.put("name", name);
            result.put("description", description);
            result.put("questions", questions);

            return name == null || description == null ? new HashMap() : result;
        } catch (Exception e) {
            fail = new HashMap();
            fail.put("status", "failure");
            fail.put("reason", e);
            return fail;
        }
    }
}
