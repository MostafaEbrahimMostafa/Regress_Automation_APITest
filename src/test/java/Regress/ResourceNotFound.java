package Regress;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResourceNotFound {

    public Response function() {
        Response response = given().
                baseUri("https://reqres.in")
                .when().get("/api/unknown/23");
        return response;
    }

    @Test
    public void TestStatusCode() {
        function().then().statusCode(404);
    }


    @Test
    public void TestResponceTime() {
        long responseTime = function().getTime();
        assert responseTime < 3000;
    }
}
