package org.kostenko.example.jcache;

import java.net.URI;
import javax.annotation.Resource;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import org.infinispan.jcache.embedded.JCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;

/**
 *
 * @author kostenko
 */
@Singleton
@Startup
public class JCacheManagerProducer {

    @Resource(lookup = "java:jboss/infinispan/container/mycachecontainer")
    private EmbeddedCacheManager cacheManager;

    @Produces
    @ApplicationScoped
    public CacheManager produceJcacheCacheManager() {
        return new JCacheManager(URI.create("mycache"), cacheManager, Caching.getCachingProvider());
    }

}
