package an.dpr.rentalcycling.renter;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

public class Renter extends ReactivePanacheMongoEntity{

    public String name;

    public String code;

}
