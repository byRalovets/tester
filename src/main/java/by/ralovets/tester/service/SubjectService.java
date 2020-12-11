package by.ralovets.tester.service;

import by.ralovets.tester.bean.Subject;
import by.ralovets.tester.service.exception.ServiceException;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjects() throws ServiceException;

    boolean addSubject(String name) throws ServiceException;

    boolean editSubject(int id, String name) throws ServiceException;

    boolean deleteSubject(int id) throws ServiceException;
}
