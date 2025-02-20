package Regress;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Invalid_Email_Register {

    public Response function() {
        Response response = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"password\":\"kady123\"\n" +
                        "   \n" +
                        "}")

                .when().post("/api/register");
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
    public void validate_register_without_email()
    {
        System.out.println("Missing email or username to Register");

    }

}
