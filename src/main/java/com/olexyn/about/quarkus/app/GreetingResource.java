package com.olexyn.about.quarkus.app;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.olexyn.about.quarkus.event.Event;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        try {
            new Event().fire().persist();
            return "Hello from RESTEasy Reactive";
        } catch (IOException ioe) {
            return "Could not log this visit.";
        }

    }


}
