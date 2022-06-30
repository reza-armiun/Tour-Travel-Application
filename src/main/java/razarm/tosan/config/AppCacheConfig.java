package razarm.tosan.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.Objects;

@Configuration
@EnableCaching
public class AppCacheConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("tours")));
        return cacheManager;
    }
    @Scheduled(fixedRate = 60 * 1000)
    public void evictCache() throws InterruptedException {
        Objects.requireNonNull(cacheManager().getCache("tours")).clear();
    }


}
