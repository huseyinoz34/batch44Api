package get_http_request;

import io.restassured.response.Response;
import org.junit.Test;
import utilietes.Authendicate;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends Authendicate {
    String endPoint="http://www.gmibank.com/api/tp-customers";
@Test
    public void test12(){
    Response response = given()
            .header("Authorization","Bearer " + generateToken())
            .when().get(endPoint).then().extract().response();

       response.prettyPrint();



}

}
