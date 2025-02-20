package Regress;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Single_User {


    public int user_number ;
    public Response function() {
        List_User ls = new List_User();
        int num = ls.ret_userId();
        Response response = given().
                baseUri("https://reqres.in")
                .when().get("/api/users/" + num);
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
    public void validate_Correct_User_data() {
        Response response = function();
        List_User l = new List_User();
        String f_str1 = response.jsonPath().getString("data.first_name");
        String f_str2 = l.ret_fisrt_name();
        Assert.assertEquals(f_str1,f_str2);
        String l_str1 = response.jsonPath().getString("data.last_name");
        String l_str2 = l.ret_last_name();
        Assert.assertEquals(l_str1,l_str2);
        String e_str1 = response.jsonPath().getString("data.email");
        String e_str2 = l.ret_email();
        Assert.assertEquals(e_str1,e_str2);
    }
}
