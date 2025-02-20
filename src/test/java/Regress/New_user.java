package Regress;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class New_user {

    public Response function() {
        Response response = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"first_name\": \"Mostafa\",\n" +
                        "    \"last_name\": \"Ebrahim\",\n" +
                        "    \"email\":\"Kady@gmail.com\",\n" +
                        "    \"job\": \"Quality Assurance engineer\" \n" +
                        "}")
                .when()
                .post("/api/users")
                .then()
                .log()
                .all()
                .extract()
                .response();
        return response;
    }

    @Test
    public void TestStatusCode() {
        function().then().statusCode(201);
    }


    @Test
    public void TestResponceTime() {
        long responseTime = function().getTime();
        assert responseTime < 3000;
    }


    @Test
    public void validate_that_new_user_is_created_successfully() {
        function()
                .then()
                .body("first_name", equalTo("Mostafa"))
                .body("last_name", equalTo("Ebrahim"))
                .body("email", equalTo("Kady@gmail.com"))
                .body("job", equalTo("Quality Assurance engineer"));
    }

}
