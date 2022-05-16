package razarm.tosan.repository.inMemoryImpl;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static AtomicLong atomicLong = new AtomicLong(0L);


    private IdGenerator() {
    }

    public static String generateId() {
        return String.valueOf(atomicLong.addAndGet(1));
    }
}
