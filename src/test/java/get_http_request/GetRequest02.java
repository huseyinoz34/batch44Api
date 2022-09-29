package get_http_request;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import  org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {

    @Test
    public void test02(){
        String url="https://reqres.in/api/users";
        Response response=given().when().get(url);
        response.prettyPeek();
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8");
      response.then().body("data[0].first_name",Matchers.equalTo("George"));
      // matcher import yaptigimiz yerde static yaparsak matchers i kaldirabiliriz

       response.then().body("data[2].first_name",Matchers.equalTo("Emma"));

    }




}



