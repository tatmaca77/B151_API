package get_request;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

public class Get02 {

    /*
    Given
      https://restful-booker.herokuapp.com/booking/0
    When
      Kullanici URL'e bir GET request gönderir
    Then
      HTTP Status Code 404 olmali
    And
      Status Line "HTTP/1.1 404 Not Found" olmali
    And
      Response body "Not Found" icermeli
    And
      Response body "TechProEd" icermemeli
    And
      Server degeri "Cowboy" olmali
     */

    @Test
    public void get02() {
        /**
         c. Otomasyon kodlarini yazarken su adimlar takip edilir:
         i. Set the URL
         ii. Set the expected data
         iii. Send the request and get the response
         iv. Do assertion
         */
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        RestAssured.basePath = "/booking/0";

        given()
                .when()
                .get()
                .then()
                .statusCode(404)
                .body(containsString("Not Found"))
                .body(not(containsString("TechProEd")))
                .header("Server", "Cowboy");

    }
        /**         Hamcrest Matchers

                .body(containsString("Not Found"))
                .body(not(containsString("TechProEd")))
           Bunlar bir Hamcrest Matchers methodlaridir. ve her zaman CoreMatchers'dan import edilmelidir. !!!!!!

         */

}
