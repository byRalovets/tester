package by.ralovets.tester.service.impl;

import by.ralovets.tester.bean.Subject;
import by.ralovets.tester.dao.SubjectDAO;
import by.ralovets.tester.dao.exception.DAOException;
import by.ralovets.tester.dao.factory.DAOFactory;
import by.ralovets.tester.service.SubjectService;
import by.ralovets.tester.service.exception.ServiceException;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    @Override
    public List<Subject> getSubjects() throws ServiceException {

        DAOFactory daoFactory = DAOFactory.getInstance();
        SubjectDAO subjectDAO = daoFactory.getSubjectDao();

        try {
            return subjectDAO.getSubjects();
        } catch (DAOException e) {
            throw new ServiceException("Error while getting subjects", e);
        }
    }

    @Override
    public boolean addSubject(String name) throws ServiceException {

        if (name.equals(""))
            return false;

        DAOFactory daoFactory = DAOFactory.getInstance();
        SubjectDAO subjectDAO = daoFactory.getSubjectDao();

        try {
            subjectDAO.addSubject(name);
        } catch (DAOException e) {
            throw new ServiceException("Error while adding subject", e);
        }
        return true;
    }

    @Override
    public boolean editSubject(int id, String name) throws ServiceException {

        if (name.equals("") || id == 0)
            return false;

        DAOFactory daoFactory = DAOFactory.getInstance();
        SubjectDAO subjectDAO = daoFactory.getSubjectDao();

        try {
            subjectDAO.editSubject(id, name);
        } catch (DAOException e) {
            throw new ServiceException("Error while editing subject", e);
        }
        return true;
    }

    @Override
    public boolean deleteSubject(int id) throws ServiceException {

        if (id == 0)
            return false;

        DAOFactory daoFactory = DAOFactory.getInstance();
        SubjectDAO subjectDAO = daoFactory.getSubjectDao();

        try {
            subjectDAO.deleteSubject(id);
        } catch (DAOException e) {
            throw new ServiceException("Error while deleting subject", e);
        }
        return true;
    }
}
