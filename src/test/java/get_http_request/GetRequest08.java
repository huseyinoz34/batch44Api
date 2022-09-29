package get_http_request;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class GetRequest08 extends DummyBaseUrl {
    /*
http://dummy.restapiexample.com/api/v1/employee/12 URL'E GiT.
1) Matcher CLASS ile
2) JsonPath ile dogrulayin.
*/
@Test
    public void test08(){

 spec02.pathParams("first","api","ikinci","v1","ucuncu","employee","dorduncu","12");
    Response response=given().spec(spec02).when().get("{first}/{ikinci}/{ucuncu}/{dorduncu}");
response.prettyPrint();
    response.then().statusCode(200).contentType(ContentType.JSON)
            .body("data.employee_name",Matchers.equalTo("Quinn Flynn"),
                    "data.employee_salary", equalTo(342000),
                    "data.employee_age", equalTo(22));

    //JSON PATH
    JsonPath json = response.jsonPath();
    System.out.println(json.getString("data.employee_name"));
    System.out.println(json.getInt("data.employee_age"));
    System.out.println(json.getInt("data.employee_salary"));

    assertEquals("Quinn Flynn",json.getString("data.employee_name"));
    assertEquals(342000,json.getInt("data.employee_salary"));
    assertEquals(22,json.getInt("data.employee_age"));

}

}
