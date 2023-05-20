package br.inatel.dm110.trabalho.api.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.inatel.dm110.trabalho.api.model.OrderTO;

@Path("/v1/order")
public interface OrderService {
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public OrderTO storeOrder(OrderTO order);

    @PATCH
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public OrderTO updateOrder(@PathParam("code") String code, OrderTO order);

    @DELETE
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteOrder(@PathParam("code") String code);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderTO> getOrders(@QueryParam("code") String code, @QueryParam("cpf") String cpf);

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public OrderTO getOrderById(@PathParam("code") String code);
}
