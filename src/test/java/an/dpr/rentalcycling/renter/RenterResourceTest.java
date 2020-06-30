package an.dpr.rentalcycling.renter;

import static io.restassured.RestAssured.given;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class RenterResourceTest {

    private static Jsonb jsonb;
     
    @BeforeAll
    public static void beforeAll() {
        jsonb = JsonbBuilder.create();
    }

    @Test
    public void testGetRenters() {
        given()
          .when().get("/renter")
          .then()
             .statusCode(200);
    }

    @Test
    public void testGetRenterById() {
        given()
          .when().get("/renter/1")
          .then()
             .statusCode(200);
    }

    @Test
    public void testPostRenter() {
        Renter renter = new Renter();
        renter.name = "renter-test";
        renter.code = "11111111H";
        given()
          .body(jsonb.toJson(renter))
          .when().post("/renter")
          .then().statusCode(201);
    }

}