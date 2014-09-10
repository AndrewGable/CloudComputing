package course.cloud.computing.rest;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 * Created by andrew on 9/9/14.
 */
public class OrderNotFoundException extends WebApplicationException {

    public OrderNotFoundException(String msg) {
        super(Response.status(Response.Status.NOT_FOUND).entity(msg)
                .type("text/plain").build());
    }

}