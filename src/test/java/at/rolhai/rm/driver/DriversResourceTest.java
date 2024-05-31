package at.rolhai.rm.driver;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;

@QuarkusTest
class DriversResourceTest {

    @Test
    void loadDrivers() {
        given()
            .when()
                .get("api/drivers")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
    
}
