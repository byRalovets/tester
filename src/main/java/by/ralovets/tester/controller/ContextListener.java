package by.ralovets.tester.controller;

import by.ralovets.tester.controller.exception.ControllerRuntimeException;
import by.ralovets.tester.dao.impl.connection.ConnectionPool;
import by.ralovets.tester.dao.impl.connection.ConnectionPoolException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            ConnectionPool.getInstance().InitPoolData();
        } catch (ConnectionPoolException e) {
            throw new ControllerRuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool.getInstance().dispose();
    }
}
