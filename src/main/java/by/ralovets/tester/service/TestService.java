package by.ralovets.tester.service;

import by.ralovets.tester.bean.Test;
import by.ralovets.tester.service.exception.ServiceException;

import java.util.List;

public interface TestService {
    List<Test> getTests(int subjectId) throws ServiceException;

    boolean addTest(int subjectId, String title) throws ServiceException;

    boolean editTest(int testId, String title) throws ServiceException;

    boolean deleteTest(int testId) throws ServiceException;
}
