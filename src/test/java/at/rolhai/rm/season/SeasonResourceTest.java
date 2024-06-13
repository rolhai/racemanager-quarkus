package at.rolhai.rm.season;

import at.rolhai.rm.season.db.SeasonEntity;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

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
