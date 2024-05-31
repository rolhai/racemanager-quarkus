package at.rolhai.rm.country;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;

@QuarkusTest
class CountriesResourceTest {
    
    @Test
    void loadCountries() {
        given()
            .when()
                .get("api/countries")
            .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
}
