package razarm.tosan.controller.servlet.filter;

import razarm.tosan.controller.servlet.MethodType;

public class PathMatcher {
    private String path;
    private MethodType[] methods = MethodType.values();
    private String[] roles = new String[]{};

    public PathMatcher(String path, MethodType[] methods, String[] roles) {
        this.path = path;
        this.methods = methods;
        this.roles = roles;
    }
    public PathMatcher() {}

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MethodType[] getMethods() {
        return methods;
    }

    public void setMethods(MethodType[] methods) {
        this.methods = methods;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }


    public static final class PathMatcherBuilder {
        private String path;
        private MethodType[] method = MethodType.values();
        private String[] roles = new String[]{};

        private PathMatcherBuilder() {
        }

        public static PathMatcherBuilder aPathMatcher() {
            return new PathMatcherBuilder();
        }

        public PathMatcherBuilder path(String path) {
            this.path = path;
            return this;
        }

        public PathMatcherBuilder method(MethodType[] method) {
            this.method = method;
            return this;
        }

        public PathMatcherBuilder roles(String[] roles) {
            this.roles = roles;
            return this;
        }

        public PathMatcher build() {
            PathMatcher pathMatcher = new PathMatcher();
            pathMatcher.setPath(path);
            pathMatcher.setMethods(method);
            pathMatcher.setRoles(roles);
            return pathMatcher;
        }
    }
}
