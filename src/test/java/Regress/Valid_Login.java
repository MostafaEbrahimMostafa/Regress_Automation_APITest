package Regress;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Valid_Login {

    public Response function() {

        File file = new File("src/test/resources/valid_login.json");
        Response response = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .body(file)

                .when().post("/api/login");
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

    @Test
    public void validate_that_user_token_is_correct()
    {
        Valid_Register v = new Valid_Register();
        Response response = function();
        String t = response.jsonPath().getString("token");
        String u_t = v.get_token();
        Assert.assertEquals(t,u_t);
    }
}
