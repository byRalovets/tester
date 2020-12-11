package by.ralovets.tester.controller.command.impl;

import by.ralovets.tester.bean.User;
import by.ralovets.tester.controller.command.Command;
import by.ralovets.tester.service.UserService;
import by.ralovets.tester.service.exception.ServiceException;
import by.ralovets.tester.service.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInCommand implements Command {

    private static final String REQUEST_PARAM_LOGIN = "login";
    private static final String REQUEST_PARAM_PASSWORD = "password";
    private static final String REDIRECT_COMMAND_SUCCESS = "Controller?command=go_to_main&signin=success";
    private static final String REDIRECT_COMMAND_ERROR = "Controller?command=go_to_main&signin=error";
    private static final String USER_SESSION_ATTR = "user";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter(REQUEST_PARAM_LOGIN);
        String password = req.getParameter(REQUEST_PARAM_PASSWORD);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        HttpSession session = req.getSession(true);

        try {
            User user = userService.signIn(login, password.getBytes());

            if (user == null)
                resp.sendRedirect(REDIRECT_COMMAND_ERROR);
            else {
                session.setAttribute(USER_SESSION_ATTR, user);
                resp.sendRedirect(REDIRECT_COMMAND_SUCCESS);
            }
        } catch (ServiceException e) {
            resp.sendRedirect(REDIRECT_COMMAND_ERROR);
        }
    }
}
