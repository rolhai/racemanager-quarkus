package at.rolhai.rm.company;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;

@QuarkusTest
class CompanyResourceTest {

    @Test
    void loadCompanies() {
        given()
            .when().get("api/companies")
            .then()
            .statusCode(Response.Status.OK.getStatusCode()); 
    }
    
}
