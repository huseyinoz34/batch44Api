package get_http_request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;



public class GetRequest5 {
    /*
    Murat TANÇ  9:43 PM
https://jsonplaceholder.typicode.com/todos/123 url’ine
   accept type’i “application/json” olan GET request’i yolladigimda
   gelen response’un
			status kodunun 200
   		ve content type’inin “application/json”
			ve Headers’daki “Server” in “cloudflare”
			ve response body’deki “userId”’nin 7
			ve “title” in “esse et quis iste est earum aut impedit”
			ve “completed” bolumunun false oldugunu test edin
     */
@Test
    public void test05(){
    String url="https://jsonplaceholder.typicode.com/todos/123";
    Response response= RestAssured.given().when().get(url);
      response.prettyPrint();
      response.then().assertThat().contentType("application/json").statusCode(200)
      .header("Server", Matchers.equalTo("cloudflare"));
response.then().body("userId",Matchers.equalTo(7));

}
}
