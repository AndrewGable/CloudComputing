package course.cloud.computing.rest;

import course.cloud.computing.rest.collections.Order;
import course.cloud.computing.rest.collections.Orders;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Created by andrew on 9/9/14.
 */

@Path("/orders")
public class OrdersService {

    @GET
    @Produces("application/xml")
    @Path("all")
    public Orders getOrders() {
        return Resource.getOrders();
    }

    @GET
    @Produces("application/xml")
    @Path("find")
    public Order getCustomersWithPhoneNumber(
            @QueryParam("EmployeeID") String EmployeeID) throws CustomerNotFoundException {
        for (Order order : Resource.getOrders().getOrders()) {
            if (order.getEmployeeId().equals(EmployeeID)) {
                return order;
            }
        }
        throw new OrderNotFoundException(" Order with EmployeeID, " + EmployeeID
                + ", is not found");
    }

}
