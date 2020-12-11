package by.ralovets.tester.dao;

import by.ralovets.tester.bean.User;
import by.ralovets.tester.dao.exception.DAOException;

public interface UserDAO {
    User signIn(String login, byte[] password) throws DAOException;

    void signUp(String login, byte[] password, String name, String lastname, String email, int roleId) throws DAOException;
}
