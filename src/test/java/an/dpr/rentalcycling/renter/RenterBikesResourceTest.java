package an.dpr.rentalcycling.renter;

import static io.restassured.RestAssured.given;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class RenterBikesResourceTest {

    private static Jsonb jsonb;
     
    @BeforeAll
    public static void beforeAll() {
        jsonb = JsonbBuilder.create();
    }

    @Test
    public void testGetRenters() {
        given()
          .when().get("/renter/bikes")
          .then()
             .statusCode(200);
    }


}