package get_http_request;

import base_url.GMIBankBasUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest18 extends GMIBankBasUrl {
    /*
http://www.gmibank.com/api/tp-customers/43703

"firstName": "Alda",
"lastName": "Monahan",
"middleInitial": "Nichelle Hermann Kohler",
"email": "com.github.javafaker.Name@7c011174@gmail.com",
"mobilePhoneNumber": "909-162-8114",
"city": "St Louis",
"ssn": "108-53-6655"

1) MATCHERS CLASS
2) JSON PATH
3) De-Serialization
 */
   @Test
   public void test18(){

     spec03.pathParams("bir","tp-customers","iki","43703")  ;

       Map<String,Object> expectedData=new HashMap<>();
       expectedData.put("firstName","Alda");
       expectedData.put("lastName","Monahan");
       expectedData.put("middleInitial","Nichelle Hermann Kohler");
       expectedData.put("email","com.github.javafaker.Name@7c011174@gmail.com");
       expectedData.put("mobilePhoneNumber","909-162-8114");
       expectedData.put("city","St Louis");
       expectedData.put("ssn","108-53-6655");

       Response response = given().spec(spec03).header("Authorization","Bearer " + generateToken()).when().get("/{bir}/{iki}");
       response.prettyPrint();


       //json ile
       JsonPath json=response.jsonPath();
       Assert.assertEquals("Alda", json.getString("firstName"));
       Assert.assertEquals("Monahan", json.getString("lastName"));
       Assert.assertEquals("Nichelle Hermann Kohler", json.getString("middleInitial"));
       Assert.assertEquals("com.github.javafaker.Name@7c011174@gmail.com", json.getString("email"));
       Assert.assertEquals("909-162-8114", json.getString("mobilePhoneNumber"));
       Assert.assertEquals("St Louis", json.getString("city"));
       Assert.assertEquals("108-53-6655", json.getString("ssn"));

       // matcher ile
       response.then().body("firstName", Matchers.equalTo("Alda")
               ,"lastName",equalTo("Monahan")
               ,"middleInitial",equalTo("Nichelle Hermann Kohler")
               ,"email",equalTo("com.github.javafaker.Name@7c011174@gmail.com")
               ,"mobilePhoneNumber",equalTo("909-162-8114")
               ,"city",equalTo("St Louis")
               ,"ssn",equalTo("108-53-6655"));


       //3) De-Serialization
       Map<String,Object>actualData=response.as(HashMap.class);
       Assert.assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
       Assert.assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
       Assert.assertEquals(expectedData.get("middleInitial"),actualData.get("middleInitial"));
       Assert.assertEquals(expectedData.get("email"),actualData.get("email"));
       Assert.assertEquals(expectedData.get("mobilePhoneNumber"),actualData.get("mobilePhoneNumber"));
       Assert.assertEquals(expectedData.get("ssn"),actualData.get("ssn"));


   }




}
