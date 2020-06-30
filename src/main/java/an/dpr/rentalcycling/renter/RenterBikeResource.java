package an.dpr.rentalcycling.renter;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import an.dpr.rentalcycling.bike.Bike;
import an.dpr.rentalcycling.bike.BikeApi;

@Path("/renterBike")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RenterBikeResource {

    @Inject
    @RestClient
    BikeApi bikeApi;

    @GET
    @Operation(
        summary = "get renter bikes by id",
        description = "Renter has a list of bikes, and this service return this data"
    )
    public List<Bike> getRenterBikes() {
        // TODO add renterId
        return bikeApi.getBikes();
    }

}