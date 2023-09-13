package get_request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {


    /*
    Given
      https://restful-booker.herokuapp.com/booking/55
    When
      Kullanici URL'e bir GET request gönderir
    Then
      HTTP Status Code 200 olmali
    And
      Content Type "application/json" olmali
    And
      Status Line "HTTP/1.1 200 OK" olmali
     */

    @Test   // Main'den kurtardi Run butonu acildi !!!!
    public void get01 (){

        // 1.WAY  --> Bu yol cok kullanilmaz API icin URL almak
        //String url = "https://restful-booker.herokuapp.com/booking/55";

        // 2. WAY  --> Daha cok tercih edilen ve olmasi gerekn URL alma islemidir. Base URL kismi sadece yazilir. .com'a kadardir.
        RestAssured.baseURI = "https://restful-booker.herokuapp.com"; // BaseURL  --> hicbir zaman degismez !!!!
        RestAssured.basePath = "/booking/55"; // BasePATH -> degisebilir !!!

        Response response = given().when().get(); // get ile cevap response olarak gelir ve dogrulamalarimizi hem response üzerinden yapariz.
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");

        // Aslinda mantik olarak sistemi tam olarak asagidaki gibi: Yani ikiside ayni sekildedir. !!!!!!

        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");

        /**
           Aslinda biz burda testin ilk adimlarini olusturuyoruz.
        given() --> URL baglantisini kuruyoruz
        when() --> Eyleme geciyoruz. Artik request islemlerine baslamis oluruz.
        then() --> Sonuclarin kontrolünü yapariz, dogrulama yapariz.Assertion
        get() --> Bize bir response verir bir cevap verir döndürür.
         */

        /**
        Test'i gerceklestirmek icin illa ki get(url) icine url'i yazmamiza gerek yok. given methodu baseURIve PATH ile iliskili calisir.
        Ama 1.yöntem kullaniliyorsa icine olusturdugumuz String url'i koymaliyiz.
         */






    }
}
