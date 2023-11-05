package at.rolhai.rm.driver.boundary;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
//@TestHTTPEndpoint(DriversResource.class)
public class DriverResourceTest {

    @Test
    public void loadDrivers() {
        given()
            .when().get("api/drivers")
            .then()
            .statusCode(200); 
    }
    
}
