package Regress;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Invalid_Email_Login {

    public Response function() {
        Response response = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .when().post("/api/login");
        return response;
    }

    @Test
    public void TestStatusCode() {
        function().then().statusCode(400);
    }


    @Test
    public void TestResponceTime() {

        long responseTime = function().getTime();
        assert responseTime < 3000;
    }

    @Test
    public void validate_login_without_Email()
    {
        System.out.println("Missing email or username to Login");

    }
}
