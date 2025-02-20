package Regress;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class List_User {


    public int id ;
    public String f_name =  "" ;
    String l_name = "";
    String e_m = " ";

    public Response function() {
        Response response =
                (Response) given().
                        baseUri("https://reqres.in")
                        .when()
                        .get("/api/users?page=2")
                        .then().log().all().extract();
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
    public void Validate_correct_data_for_all_users_for_page_2 () {
        function()
                .then()
                .body("page", equalTo(2))
                .body("per_page", equalTo(6))
                .body("total", equalTo(12))
                .body("total_pages", equalTo(2));
    }

    public int ret_userId()
    {
        Response response = function();
        id = Integer.parseInt(response.jsonPath().getString("data[0].id"));
        return id ;
    }

    public String ret_fisrt_name()
    {
        Response response = function();
        f_name = response.jsonPath().getString("data[0].first_name");
        return f_name ;
    }
    public String ret_last_name()
    {
        Response response = function();
        l_name = response.jsonPath().getString("data[0].last_name");
        return l_name ;
    }
    public String ret_email()
    {
        Response response = function();
        e_m = response.jsonPath().getString("data[0].email");
        return e_m ;
    }

}




