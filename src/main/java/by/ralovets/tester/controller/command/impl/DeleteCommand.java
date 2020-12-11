package by.ralovets.tester.controller.command.impl;

import by.ralovets.tester.controller.command.Command;
import by.ralovets.tester.service.AnswerService;
import by.ralovets.tester.service.QuestionService;
import by.ralovets.tester.service.SubjectService;
import by.ralovets.tester.service.TestService;
import by.ralovets.tester.service.exception.ServiceException;
import by.ralovets.tester.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCommand implements Command {

    private static final String REQUEST_PARAM_ID = "id";
    private static final String REQUEST_PARAM_ENTITY = "entity";

    private static final String ENTITY_SUBJECT = "subject";
    private static final String ENTITY_TEST = "test";
    private static final String ENTITY_QUESTION = "question";
    private static final String ENTITY_ANSWER = "answer";
    private static final String REDIRECT_COMMAND_SUCCESS_SUBJECT = "Controller?command=go_to_main";
    private static final String REDIRECT_COMMAND_ERROR_SUBJECT = "Controller?command=go_to_main&error=subject";
    private static final String REDIRECT_COMMAND_SUCCESS_TEST = "Controller?command=go_to_tests";
    private static final String REDIRECT_COMMAND_ERROR_TEST = "Controller?command=go_to_tests&error=test";
    private static final String REDIRECT_COMMAND_SUCCESS_QUESTION = "Controller?command=go_to_questions";
    private static final String REDIRECT_COMMAND_ERROR_QUESTION = "Controller?command=go_to_questions&error=question";


    private static final String REDIRECT_COMMAND_ERROR = "Controller?command=go_to_main&error=error";


    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String entity = ((String) req.getParameter(REQUEST_PARAM_ENTITY));
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Boolean result;

        switch (entity) {
            case ENTITY_SUBJECT:
                int id = Integer.parseInt(req.getParameter(REQUEST_PARAM_ID));
                SubjectService subjectService = serviceFactory.getSubjectService();
                try {
                    result = subjectService.deleteSubject(id);
                    if (result)
                        resp.sendRedirect(REDIRECT_COMMAND_SUCCESS_SUBJECT);
                    else
                        resp.sendRedirect(REDIRECT_COMMAND_ERROR_SUBJECT);
                } catch (ServiceException e) {
                    resp.sendRedirect(REDIRECT_COMMAND_ERROR);
                }
                break;

            case ENTITY_TEST:
                int testId = Integer.parseInt(req.getParameter(REQUEST_PARAM_ID));
                TestService testService = serviceFactory.getTestService();
                try {
                    result = testService.deleteTest(testId);
                    if (result)
                        resp.sendRedirect(REDIRECT_COMMAND_SUCCESS_TEST);
                    else
                        resp.sendRedirect(REDIRECT_COMMAND_ERROR_TEST);
                } catch (ServiceException e) {
                    resp.sendRedirect(REDIRECT_COMMAND_ERROR);
                }
                break;

            case ENTITY_QUESTION:
                int questionId = Integer.parseInt(req.getParameter(REQUEST_PARAM_ID));
                QuestionService questionService = serviceFactory.getQuestionService();
                try {
                    result = questionService.deleteQuestion(questionId);
                    if (result)
                        resp.sendRedirect(REDIRECT_COMMAND_SUCCESS_QUESTION);
                    else
                        resp.sendRedirect(REDIRECT_COMMAND_ERROR_QUESTION);
                } catch (ServiceException e) {
                    resp.sendRedirect(REDIRECT_COMMAND_ERROR);
                }
                break;

            case ENTITY_ANSWER:
                int answerId = Integer.parseInt(req.getParameter(REQUEST_PARAM_ID));
                AnswerService answerService = serviceFactory.getAnswerService();
                try {
                    result = answerService.deleteAnswer(answerId);
                    if (result)
                        resp.sendRedirect(REDIRECT_COMMAND_SUCCESS_QUESTION);
                    else
                        resp.sendRedirect(REDIRECT_COMMAND_ERROR_QUESTION);
                } catch (ServiceException e) {
                    resp.sendRedirect(REDIRECT_COMMAND_ERROR);
                }
                break;

            default:
                resp.sendRedirect(REDIRECT_COMMAND_ERROR);
        }
    }
}
