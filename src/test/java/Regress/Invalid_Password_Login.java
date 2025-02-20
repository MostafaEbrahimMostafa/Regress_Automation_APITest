package Regress;

import Pojo.Invalid_login;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Invalid_Password_Login {

    public Response function() {

        Invalid_login b = new Invalid_login();
        b.setEmail("eve.holt@reqres.in");
        Response response = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .body(b)

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
    public void validate_login_without_password()
    {
        System.out.println("Missing password to Login ");

    }
}


