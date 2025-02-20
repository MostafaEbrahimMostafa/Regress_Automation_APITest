package Regress;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Single_Resource {

    public int user_number ;
    public Response function() {
        List_Resource lr = new List_Resource();
        int num = lr.ret_resourceId();
        Response response = given().
                baseUri("https://reqres.in")
                .when().get("/api/unknown/" + num);
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
    public void validate_Correct_Resource_data() {
        Response response = function();
        List_Resource lrs = new List_Resource();
        String rn_str1 = response.jsonPath().getString("data.name");
        String rn_str2 = lrs.ret_resource_name();
        Assert.assertEquals(rn_str1,rn_str2);
        int ry_str1 = Integer.parseInt(response.jsonPath().getString("data.year"));
        int ry_str2 = lrs.ret_resource_year();
        Assert.assertEquals(ry_str1,ry_str2);
        String rc_str1 = response.jsonPath().getString("data.color");
        String rc_str2 = lrs.ret_resource_color();
        Assert.assertEquals(rc_str1,rc_str2);
        String rp_str1 = response.jsonPath().getString("data.pantone_value");
        String rp_str2 = lrs.ret_resource_pantone_value();
        Assert.assertEquals(rp_str1,rp_str2);

    }
}
