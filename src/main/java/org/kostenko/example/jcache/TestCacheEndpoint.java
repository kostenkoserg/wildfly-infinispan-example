package org.kostenko.example.jcache;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 *
 * @author kostenko
 */
@Stateless
@ApplicationPath("/")
@Path("/jcache")
public class TestCacheEndpoint extends Application {

    @Inject
    TestCacheService service;

    @GET
    @Path("/ispn-put")
    public Response putIspn(@QueryParam("key") String key, @QueryParam("value") String value) {
        service.putIspnCache(key, value);
        return Response.ok("ok").build();
    }
    
    @GET
    @Path("/ispn-get")
    public Response getIspn(@QueryParam("key") String key) {
        return Response.ok(service.getIspnCache(key)).build();
    }
    
    @Path("cache-result")
    @GET
    public String cacheResult() {
        return service.getJCacheResult();
    }

}


