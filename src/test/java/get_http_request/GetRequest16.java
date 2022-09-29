package get_http_request;

import base_url.JsonPlaceBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest16 extends JsonPlaceBaseUrl {

     /*
   https://jsonplaceholder.typicode.com/todos/7

   {
   "userId": 1,
   "id": 7,
   "title": "illo expedita consequatur quia in",
   "completed": false
}
    */

@Test
    public void test16(){
// Url olusturma
    spec04.pathParams("bir","todos","iki","7");
    // beklenen data olusturma
    Map<String,Object> expectedData=new HashMap<>();
    expectedData.put("userId",1);
    expectedData.put("id",7);
    expectedData.put("title","illo expedita consequatur quia in");
    expectedData.put("completed",false);

    System.out.println(expectedData);
    //DATAYI JSON'DAN -> JAVA'YA De-Serialization
    //DATAYI JAVA'DAN -> JSON'A Serialization
    //request response
  Response response=given().spec(spec04).when().get("/{bir}/{iki}");
response.prettyPrint();
Map<String,Object> actuelData=response.as(HashMap.class);//De-Serialization
    Assert.assertEquals(expectedData.get("userId"),actuelData.get("userId"));
    Assert.assertEquals(expectedData.get("id"),actuelData.get("id"));
    Assert.assertEquals(expectedData.get("title"),actuelData.get("title"));
    Assert.assertEquals(expectedData.get("completed"),actuelData.get("completed"));

}
}
