package Regress;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class List_Resource {

    public int id ;
    public String r_name =  "" ;
    public int r_year ;
    public String r_color = " ";
    public String r_pantone_value = " ";

    public Response function() {
        Response response = given().
                baseUri("https://reqres.in")
                .when().get("/api/unknown");
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
    public void Validate_correct_data_for_all_resources_for_page_1 () {
        function()
                .then()
                .body("page", equalTo(1))
                .body("per_page", equalTo(6))
                .body("total", equalTo(12))
                .body("total_pages", equalTo(2));
    }

    public int ret_resourceId()
    {

        Response response = function();
        id = Integer.parseInt(response.jsonPath().getString("data[2].id"));
        return id ;
    }

    public String ret_resource_name()
    {

        Response response = function();
        r_name = response.jsonPath().getString("data[2].name");
        return r_name ;
    }
    public int ret_resource_year()
    {
        Response response = function();
        r_year = Integer.parseInt(response.jsonPath().getString("data[2].year"));
        return r_year ;
    }
    public String ret_resource_color()
    {
        Response response = function();
        r_color = response.jsonPath().getString("data[2].color");
        return r_color ;
    }
    public String ret_resource_pantone_value()
    {
        Response response = function();
        r_pantone_value = response.jsonPath().getString("data[2].pantone_value");
        return r_pantone_value ;
    }




}
