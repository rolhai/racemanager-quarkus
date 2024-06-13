package at.rolhai.rm.event;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;

@QuarkusTest
class EventResourceTest {
    
    @Test
    void loadEvents() {
        given()
            .when()
                .get("api/events")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
}
