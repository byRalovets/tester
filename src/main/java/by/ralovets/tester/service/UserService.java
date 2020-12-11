package by.ralovets.tester.service;

import by.ralovets.tester.bean.User;
import by.ralovets.tester.service.exception.ServiceException;

public interface UserService {
    User signIn(String login, byte[] password) throws ServiceException;

    boolean signUp(String login, byte[] password, String name, String lastname, String email, int roleId) throws ServiceException;
}
