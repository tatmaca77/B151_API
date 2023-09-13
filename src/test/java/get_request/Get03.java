package get_request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 {

    /*
    Given
      https://jsonplaceholder.typicode.com/todos/23   -- > Önce her zaman Postman'e gidip manuel olarak Test yap. URL kopyala yapistir
    When
      Kullanici URL'e bir GET request gönderir
    Then
      HTTP Status Code 200 olmali
    And
      Content Type "application/json" olmali
    And
      "title" su metni icermeli: "et itaque necessitatibus maxime molestiae qui quas velit"
    And
      "completed" degeri false olmali
    And
      "userId" degeri 2 olmali

     */

    @Test
    public void hardAssertion() {

        // HARD ASSERTION
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "todos/23";

        given()
                .when()
                .get()
                .then()
                .statusCode(200)              // ContentType.JSON = Content Type "application/json"
                .contentType(ContentType.JSON)// .contentType("application/json") aslinda böylede oluyor ama yazim hatasi olamamsi icin hazir olani kullandik
                .body("title", containsString("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed", equalTo(false))
                .body("userId", equalTo(2));
        /*
        containsString
        equalTo            Hamscrest Matchers Methodlaridir. Her zaman CoreMatchers'tan import edilir.

         */
    }

    @Test
    public void softAssertion() {

        // SOFT ASSERTION
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "todos/23";

        given()
                .when()
                .get()
                .then()
                .statusCode(200)              // ContentType.JSON = Content Type "application/json"
                .contentType(ContentType.JSON)// .contentType("application/json") aslinda böylede oluyor ama yazim hatasi olamamsi icin hazir olani kullandik
                .body("title", containsString("et itaque necessitatibus maxime molestiae qui quas velitX")
                        , "completed", equalTo(true)
                        , "userId", equalTo(1));

    }


}
