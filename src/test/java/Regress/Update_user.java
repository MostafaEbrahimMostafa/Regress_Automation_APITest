package Regress;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Update_user {

    public Response function() {
        Response response = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"first_name\": \"Ahmed\",\n" +
                        "    \"last_name\": \"Ali\",\n" +
                        "    \"email\":\"Ahmed@gmail.com\",\n" +
                        "    \"job\": \"Quality Control  engineer\" \n" +
                        "}")

                .when().put("/api/users/2");
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
    public void validate_that_new_user_is_Updated_successfully() {
        function()
                .then()
                .body("first_name", equalTo("Ahmed"))
                .body("last_name", equalTo("Ali"))
                .body("email", equalTo("Ahmed@gmail.com"))
                .body("job", equalTo("Quality Control  engineer"));
    }

}
