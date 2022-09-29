package get_http_request;

import base_url.GMIBankBasUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends GMIBankBasUrl {
/*
  “firstName”: “Della”,
    “lastName”: “Heaney”,
    “mobilePhoneNumber”: “123-456-7893”,
    “address”: “75164 McClure Stream”,
    “country” : “USA”
    “state”: “New York43"
    “CREDIT_CARD”,hesabında 69700$ ,
    “CHECKING” hesabında 11190$
 */

@Test
    public void test13(){

    spec03.pathParams("bir","tp-customers","iki","114351");
    Response response = given().spec(spec03).header("Authorization","Bearer " + generateToken()).when().get("/{bir}/{iki}");
response.prettyPrint();


// matcher class ile




 // json ile

}




}
