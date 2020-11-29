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
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> ispn-put <<<<<<<<<<<<<<<<<<<<<<<<");
        service.putIspnCache(key, value);
        return Response.ok("ok").build();
    }

    @GET
    @Path("/ispn-get")
    public Response getIspn(@QueryParam("key") String key) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> ispn-get <<<<<<<<<<<<<<<<<<<<<<<<");
        return Response.ok(service.getIspnCache(key)).build();
    }

    @GET
    @Path("/ispn-remote-put")
    public Response putRemoteCache(@QueryParam("key") String key, @QueryParam("value") String value) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> ispn-remote-put <<<<<<<<<<<<<<<<<<<<<<<<");
        service.putRemoteCache(key, value);
        return Response.ok("ok").build();
    }

    @GET
    @Path("/ispn-remote-get")
    public Response getRemoteCache(@QueryParam("key") String key) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> ispn-remote-get <<<<<<<<<<<<<<<<<<<<<<<<");
        return Response.ok(service.getRemoteCache(key)).build();
    }


}


