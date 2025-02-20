package Regress;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Valid_Register {

    public Response function() {

        // Send body as hashMap (key and value)
        // must do deserialization to convert json to hashMap

        HashMap<String,String> body = new HashMap<>();
        body.put("email" , "eve.holt@reqres.in");
        body.put("password" , "pistol");

        Response response = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .body(body)

                .when().post("/api/register");
        return response;
    }


    @Test
    public void TestStatusCode() {
        function().then().statusCode(200);
    }


    @Test
    public void TestResponceTime() {
        long responseTime = function().getTime();
        assert responseTime < 3000;
    }


    public String get_token ()
    {
        Response response = function();
        String user_t = response.jsonPath().getString("token");
        return user_t;
    }

}
