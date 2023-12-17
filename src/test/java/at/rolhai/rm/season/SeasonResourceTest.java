package at.rolhai.rm.season;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;

@QuarkusTest
class SeasonResourceTest {
    
    @Test
    void loadSeasons() {
        given()
            .when().get("api/seasons")
            .then()
            .statusCode(Response.Status.OK.getStatusCode()); 
    }
}
