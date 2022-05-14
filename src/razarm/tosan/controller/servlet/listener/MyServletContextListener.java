package razarm.tosan.controller.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class MyServletContextListener implements ServletContextListener {
    Logger logger = Logger.getLogger(MyServletContextListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        logger.info("initialized######################################################################");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
        logger.info("destroyed");
    }
}
