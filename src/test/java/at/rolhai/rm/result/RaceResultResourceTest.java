package at.rolhai.rm.result;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;

@QuarkusTest
public class RaceResultResourceTest {

    @Test
    void loadRaceResults() {
        given()
            .when()
                .get("api/races/results")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
    
}
