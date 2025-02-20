package Regress;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Delete_User {

    public Response function() {
        Response response = given()
                .baseUri("https://reqres.in")
                .when().delete("/api/users/2");
        return response;
    }

    @Test
    public void TestStatusCode() {
        function().then().statusCode(204);
    }


    @Test
    public void TestResponceTime() {
        long responseTime = function().getTime();
        assert responseTime < 3000;
    }

}
