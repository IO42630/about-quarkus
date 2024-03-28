package com.olexyn.about.quarkus.app

import com.olexyn.about.quarkus.event.Event
import java.io.IOException
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        try {
            Event().fire().persist()
            AzureSqlCon().test()
            return "Hello from RESTEasy Reactive"
        } catch (ioe: IOException) {
            return "Could not log this visit."
        }
    }
}
