package org.kostenko.example.jcache;

import java.util.Date;
import javax.annotation.Resource;
import javax.inject.Named;

import org.infinispan.Cache;

/**
 * @author kostenko
 */
@Named
public class TestCacheService {

    @Resource(name = "mycache")
    Cache cache;

    @Resource(name = "myremotecontainer")
    //@Resource(lookup = "java:jboss/infinispan/remote-container/myRemoteContainer")
    private org.infinispan.client.hotrod.RemoteCacheContainer remoteCacheContainer;

    public static final String REMOTE_CACHE_NAME = "myremotecache";


    public void putIspnCache(String key, String value) {
        cache.put(key, String.format("%s (%s)", value, new Date()));
    }

    public Object getIspnCache(String key) {
        return cache.get(key);
    }

    public void putRemoteCache(String key, String value) {
        remoteCacheContainer.getCache(REMOTE_CACHE_NAME).put(key, String.format("%s (%s)", value, new Date()));
    }

    public Object getRemoteCache(String key) {
        return remoteCacheContainer.getCache(REMOTE_CACHE_NAME).get(key);
    }
}
