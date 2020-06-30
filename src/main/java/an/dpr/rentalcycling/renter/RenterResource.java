package an.dpr.rentalcycling.renter;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import an.dpr.rentalcycling.bike.BikeApi;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

@Path("/renter")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RenterResource {

    @GET
    @Operation(
        summary = "get all renters",
        description = "get all renters, without any filter"
    )
    public Multi<Renter> getAllRenters() {
        return Renter.streamAll();
    }
   
    @GET
    @Path("{id}")
    @Operation(
        summary = "get renter by id",
        description = "get all renters, without any filter"
    )
    public Uni<Renter> getRenterById(
        @Parameter(
            description = "renter id",
            required = true,
            example = "6asf87gsodf"
        )
        @PathParam("id") ObjectId id
    ) {
        return Renter.findById(id);
    }

    @POST
    @Operation(
        summary = "Save a new renter",
        description = "Save a new renter"
    )
    public Uni<Response> newRenter(
        @Parameter(
            description = "renter to save",
            required = true,
            example = "{name:'renter', code:'11111111H'"
        )
        Renter renter
    ) {
        return renter.persist()
        .onItem().apply(voidItem -> URI.create("renter/"+renter.id))
        .onItem().apply(uri -> Response.created(uri).build());
    }

    @PUT
    @Operation(
        summary = "Update existing renter",
        description = "Update existing renter"
    )
    public Uni<Response> updateRenter(
        @Parameter(
            description = "existing renter to update",
            required = true,
            example = "{name:'renter', code:'11111111H'"
        )
        Renter renter
    ) {
        return renter.update()
        .onItem().apply(voidItem -> URI.create("renter/"+renter.id))
        .onItem().apply(uri -> Response.created(uri).build());
    }


}