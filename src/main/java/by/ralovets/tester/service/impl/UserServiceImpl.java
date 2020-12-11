package by.ralovets.tester.service.impl;

import by.ralovets.tester.bean.User;
import by.ralovets.tester.dao.UserDAO;
import by.ralovets.tester.dao.exception.DAOException;
import by.ralovets.tester.dao.exception.DAOUserAlreadyExistsException;
import by.ralovets.tester.dao.factory.DAOFactory;
import by.ralovets.tester.service.UserService;
import by.ralovets.tester.service.exception.ServiceException;
import by.ralovets.tester.service.exception.ServiceUserAlreadyExistsException;

public class UserServiceImpl implements UserService {
    @Override
    public User signIn(String login, byte[] password) throws ServiceException {

        if (login.equals("") || password.equals(""))
            return null;

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDao();

        try {
            return userDAO.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException("Error while signing in", e);
        }
    }

    @Override
    public boolean signUp(String login, byte[] password, String name, String lastname, String email, int roleId) throws ServiceException {

        if (login.equals("") || password.equals("") || name.equals("") || lastname.equals("") || email.equals(""))
            return false;

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDao();

        try {
            userDAO.signUp(login, password, name, lastname, email, roleId);
        } catch (DAOUserAlreadyExistsException e) {
            throw new ServiceUserAlreadyExistsException("User with such login already exists", e);
        } catch (DAOException e) {
            throw new ServiceException("Error while singing up", e);
        }
        return true;
    }
}
