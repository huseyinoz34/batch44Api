package get_http_request;


import base_url.HerOuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test.data.HerOkuAppTestData;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest22 extends HerOuAppBaseUrl {
      /*
   https://restful-booker.herokuapp.com/booking/47
          {
              "firstname": "Ali",
              "lastname": "Can",
              "totalprice": 500,
              "depositpaid": true,
              "bookingdates": {
                                "checkin": "2022-02-01",
                                    "checkout": "2022-02-11"
             }
          }
   1) JsonPhat
   2) De-Serialization
   */

    @Test
    public void test22(){
        //1) URL OLUSTUR
        spec05.pathParams("first", "booking", "second", 41);

        //2) EXPECTED DATA OLUSTUR
        HerOkuAppTestData expectedObje = new HerOkuAppTestData();

        HashMap<String , Object> expectedTestDataMap = expectedObje.setUpTestData();

        System.out.println("TEST DATA iCiNDEKi EXPECTED DATA: " + expectedTestDataMap);
        // {firstname=Ali,
        // bookingdates={
        //               checkin=2022-02-01,
        //               checkout=2022-02-11},
        // totalprice=500,
        // depositpaid=true,
        // lastname=Can}

        //3) REQUEST VE RESPONSE
        Response response = given().spec(spec05).when().get("/{first}/{second}");
        response.prettyPrint();

        //4) DOGRULAMA
        //1. Yol De-Serialization

        HashMap<String, Object> actualData= response.as(HashMap.class);
        //JSON formatındaki datayı HashMap'e donüştürür.

        System.out.println("ACTUAL DATA: " + actualData);
        //{firstname=Ali,
        // bookingdates={
        //               checkin=2022-02-01,
        //               checkout=2022-02-11},
        // totalprice=500,
        // depositpaid=true,
        // lastname=Can}

        Assert.assertEquals(expectedTestDataMap.get("firstname"), actualData.get("firstname"));
        Assert.assertEquals(expectedTestDataMap.get("lastname"), actualData.get("lastname"));
        Assert.assertEquals(expectedTestDataMap.get("totalprice"), actualData.get("totalprice"));
        Assert.assertEquals(expectedTestDataMap.get("depositpaid"), actualData.get("depositpaid"));

        Assert.assertEquals(((Map)expectedTestDataMap.get("bookingdates")).get("checkin"),
                ((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map<?, ?>) expectedTestDataMap.get("bookingdates")).get("checkout"),
                ((Map<?, ?>) actualData.get("bookingdates")).get("checkout"));
    }
}