package at.rolhai.rm.season;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertFalse;

@QuarkusTest
class SeasonResourceTest {
    
    @Test
    void loadSeasons() {
        given()
            .when()
                .get("api/seasons")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
}
