package by.ralovets.tester.dao;

import by.ralovets.tester.bean.Subject;
import by.ralovets.tester.dao.exception.DAOException;

import java.util.List;

public interface SubjectDAO {
    List<Subject> getSubjects() throws DAOException;

    void addSubject(String name) throws DAOException;

    void editSubject(int id, String name) throws DAOException;

    void deleteSubject(int id) throws DAOException;
}
