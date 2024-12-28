package at.rolhai.rm.championship;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;

@QuarkusTest
public class ChampionshipResultResourceTest {

    @Test
    void loadRaceResults() {
        given()
            .when()
                .get("api/championships/results")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
    
}
