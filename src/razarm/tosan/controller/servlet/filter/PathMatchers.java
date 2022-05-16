package razarm.tosan.controller.servlet.filter;

import java.util.ArrayList;
import java.util.List;

public class PathMatchers {
    private List<PathMatcher> matchers ;

    private PathMatchers(List<PathMatcher> matchers) {
        this.matchers = matchers;
    }


    public List<PathMatcher> getMatchers() {
        return matchers;
    }

    public static aBuilder builder() {
        return new aBuilder();
    }



    public static final class aBuilder {
        private List<PathMatcher> matchers = new ArrayList<>();

        private aBuilder() {
        }


        public aBuilder matcher(PathMatcher pathMatcher) {
            this.matchers.add(pathMatcher);
            return this;
        }



        public PathMatchers build() {
            return new PathMatchers(matchers);
        }
    }


}
