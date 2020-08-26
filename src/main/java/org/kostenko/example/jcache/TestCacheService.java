package org.kostenko.example.jcache;

import java.util.Date;
import javax.annotation.Resource;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.inject.Named;
import org.infinispan.Cache;

/**
 *
 * @author kostenko
 */
@Named
@CacheDefaults(cacheName = "mycache")
public class TestCacheService {

    @Resource(name = "mycache")
    Cache cache;
    
    public void putIspnCache(String key, String value) {
        cache.put(key, String.format("%s (%s)", value, new Date()));
    }

    public Object getIspnCache(String key) {
        return cache.get(key);
    }
    
    @CacheResult(cacheName = "mycache")
    public String getJCacheResult() {
        System.out.println("getJCacheResult");
        return new Date().toString();
    }
}
