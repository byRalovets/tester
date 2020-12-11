package by.ralovets.tester.dao.factory;

import by.ralovets.tester.dao.*;
import by.ralovets.tester.dao.impl.*;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final static UserDAO sqlUserImpl = new UserDAOImpl();
    private final static SubjectDAO sqlSubjectImpl = new SubjectDAOImpl();
    private final static TestDAO sqlTestImpl = new TestDAOImpl();
    private final static AnswerDAO sqlAnswerImpl = new AnswerDAOImpl();
    private final static QuestionDAO sqlQuestionImpl = new QuestionDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDao() {
        return sqlUserImpl;
    }

    public SubjectDAO getSubjectDao() {
        return sqlSubjectImpl;
    }

    public TestDAO getTestDao() {
        return sqlTestImpl;
    }

    public AnswerDAO getAnswerDao() {
        return sqlAnswerImpl;
    }

    public QuestionDAO getQuestionDao() {
        return sqlQuestionImpl;
    }
}
