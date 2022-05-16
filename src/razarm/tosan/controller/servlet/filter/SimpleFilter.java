package razarm.tosan.controller.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.Logger;


@WebFilter(urlPatterns = {"/*"})
public class SimpleFilter implements Filter {

    Logger logger = Logger.getLogger(SimpleFilter.class.getName());





    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, javax.servlet.FilterChain filterChain) throws IOException, ServletException {
        logger.info("Filtering....");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
