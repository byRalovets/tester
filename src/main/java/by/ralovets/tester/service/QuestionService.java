package by.ralovets.tester.service;

import by.ralovets.tester.bean.Question;
import by.ralovets.tester.service.exception.ServiceException;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestions(int testId) throws ServiceException;

    boolean addQuestion(int testId, String question) throws ServiceException;

    boolean editQuestion(int questionId, String question) throws ServiceException;

    boolean deleteQuestion(int questionId) throws ServiceException;
}
