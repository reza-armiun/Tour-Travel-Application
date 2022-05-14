package razarm.tosan.controller.servlet.filter;

import razarm.tosan.AppContextHolder;
import razarm.tosan.controller.servlet.MethodType;
import razarm.tosan.repository.domain.auth.Authority;
import razarm.tosan.repository.domain.auth.UserDetails;
import razarm.tosan.service.AuthService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class AuthenticationFilter extends HttpFilter {
    Logger logger = Logger.getLogger(AuthenticationFilter.class.getName());
    private PathMatchers pathMatchers;

    @Override
    public void init() throws ServletException {
        super.init();
        this.pathMatchers =
                PathMatchers.builder()
                        .matcher(PathMatcher.PathMatcherBuilder.aPathMatcher().path("/home").method(MethodType.values()).roles(new String[]{"ROLE_BASIC"}).build())
                        .matcher(PathMatcher.PathMatcherBuilder.aPathMatcher().path("/login").method(MethodType.values()).build())
                        .matcher(PathMatcher.PathMatcherBuilder.aPathMatcher().path("/secure").method(MethodType.values()).roles(new String[]{"ROLE_BASIC"}).build())
                        .matcher(PathMatcher.PathMatcherBuilder.aPathMatcher().path("/secure/*").method(MethodType.values()).roles(new String[]{"ROLE_ADMIN"}).build())
                        .build();
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) req.getSession().getAttribute("principal");
        logger.info("Servlet path" + req.getRequestURI());
        var path = req.getRequestURI().replaceFirst("/tour", "");
        var pathMatcher =
                pathMatchers.getMatchers().stream()
                            .filter(s -> {
                                if(s.getPath().equals(path)) return true;
                                if(s.getPath().contains("/*")) {
                                    return path.matches(s.getPath().replace("/*", "/.*"));
                                }
                                return false;
                            })
                            .findFirst()
                            .orElse(null);
        if (pathMatcher != null ) {
            if (userDetails == null && pathMatcher.getRoles().length > 0 ) {
                if (!path.equals("/login")) {
                    res.sendRedirect(req.getContextPath() + "/login");
                    return;
                }
            } else {
                if (userDetails != null && path.equals("/login")) {
                    res.sendRedirect(req.getContextPath() + "/home");
                return;

                }else
                    checkAuthorization(req, res, userDetails, pathMatcher);
            }

        }

        chain.doFilter(req, res);
    }

    private void checkAuthorization(HttpServletRequest req, HttpServletResponse res, UserDetails userDetails, PathMatcher pathMatcher) throws ServletException, IOException {
        var roles = pathMatcher.getRoles();
        for (String role : roles) {
            var authority =
                    userDetails.getAuthorities().stream()
                               .map(Authority::getName)
                               .map(s -> "ROLE_"+s)
                               .filter(s -> s.equals(role))
                               .findFirst()
                               .orElse(null);
            logger.info("User Authority : " + authority);
            if (authority == null  || Arrays.stream(pathMatcher.getMethods())
                                           .noneMatch(methodType -> methodType.getName().equals(req.getMethod()))) {
                res.sendRedirect(req.getContextPath() + "/login"); //todo
                return;

            }
        }
    }





}
