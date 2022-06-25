package razarm.tosan.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import razarm.tosan.service.tour.TourService;

import java.util.Arrays;
import java.util.Objects;

@Configuration
@EnableCaching
@Slf4j
public class AppCacheConfig {
    @Autowired
    private TourService tourService;
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
