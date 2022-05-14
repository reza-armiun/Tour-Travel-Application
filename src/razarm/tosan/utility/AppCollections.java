package razarm.tosan.utility;

import java.util.Collections;
import java.util.Set;

final public class AppCollections {

    public static <T> Set<T> unmodifiableSet(Set<? extends T> s) {
        if(s == null) return Collections.emptySet();
        return Collections.unmodifiableSet(s);
    }
}
