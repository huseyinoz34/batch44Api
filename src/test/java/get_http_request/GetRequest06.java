package get_http_request;

import base_url.Regresin_Base;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06  extends Regresin_Base {

/*
    https://reqres.in/api/users URL request olustur.
    body icerisindeki idsi 5 olan datayi
    1) Matcher CLASS ile
    2) JsonPath ile dogrulayin.
    */

    @Test
    public void test07() {

        spec01.pathParams("parametre1", "api", "parametre2", "users");

        //  https://reqres.in
        Response response = given().spec(spec01).when().get("/{parametre1}/{parametre2}");
        // "/{parametre1}/{parametre2}" -> /api/users
// matcher class ile
        response.prettyPrint();
        response.then().assertThat().body("data[4].email", Matchers.equalTo("charles.morris@reqres.in"));
        //json path ile

        JsonPath json = response.jsonPath();
        System.out.println(json.getList("data.email"));
        System.out.println(json.getString("data.first_name"));
        Assert.assertEquals("charles.morris@reqres.in",json.getString("data[4].email"));
    }
}