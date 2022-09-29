package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilietes.Authendicate;

public class GMIBankBasUrl extends Authendicate {

    public RequestSpecification spec03;

    @Before
    public void setUp(){

        spec03 = new RequestSpecBuilder().setBaseUri("http://www.gmibank.com/api").build();



    }

}
