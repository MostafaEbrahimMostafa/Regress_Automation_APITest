package Regress;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Delyed_Responce {
    public Response function() {
        Response response = given()
                .baseUri("https://reqres.in")
                .when().get("/api/users?delay=3");
        return response;
    }

    @Test
    public void TestStatusCode() {
        function().then().statusCode(200);
    }


    @Test
    public void TestResponceTime() {
        long responseTime = function().getTime();
        assert responseTime > 3000;
    }
}
