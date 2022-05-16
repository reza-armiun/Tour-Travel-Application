package razarm.tosan.controller.servlet.listener;

import razarm.tosan.AppContextHolder;
import razarm.tosan.MockDataInitializer;

import javax.naming.directory.InvalidAttributeValueException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class MyServletContextListener implements ServletContextListener {
    Logger logger = Logger.getLogger(MyServletContextListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        try {
            MockDataInitializer.initialize();
            logger.info("initialized...#############################");
        } catch (InvalidAttributeValueException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
        logger.info("destroyed");
    }
}
