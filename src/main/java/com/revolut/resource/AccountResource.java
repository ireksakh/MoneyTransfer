package com.revolut.resource;

import com.revolut.model.Account;
import com.revolut.service.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/money")
public class AccountResource {

    private AccountService accountService = new AccountService();

    @GET
    @Path("/account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAccountById(@PathParam(value = "id") int id) {
        Account account = accountService.getAccountById(id);
        return Response.status(Response.Status.OK).entity(account).build();

    }

    @GET
    @Path("/account/{id}/balance")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAccountBalance(@PathParam(value = "id") int id) {
        double balance = accountService.gerAccountBalance(id);
        return Response.status(Response.Status.OK).entity(balance).build();
    }

    @POST
    @Path("/transfer/{source}/{destination}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response transfer(@PathParam(value = "source") int source, @PathParam(value = "destination") int destination, @PathParam(value = "amount") double amount) {
        accountService.transfer(source, destination, amount);
        return Response.status(Response.Status.OK).entity("money is transferred").build();
    }
}
