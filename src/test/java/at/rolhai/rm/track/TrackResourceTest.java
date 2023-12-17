package at.rolhai.rm.track;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;

@QuarkusTest
class TrackResourceTest {
    
    @Test
    void loadTracks() {
        given()
            .when().get("api/tracks")
            .then()
            .statusCode(Response.Status.OK.getStatusCode()); 
    }
}
