package an.dpr.rentalcycling.bike;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/bike")
@RegisterRestClient
public interface BikeApi {

    @GET
    public List<Bike> getBikes();
}