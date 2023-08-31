package get_request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /**
      NOTES:
         1- "Manuel Testler" icin "Postman" kullaniriz.
         2- "API otomasyon testleri" icin "REST Assured" kütüphanesini kullaniriz.
         3- Otomasyon kodlari yazarken su adimlari takip ederiz_:
            a. Gereksinimleri anlamak
            b. Test senaryolarini yazmak
               i. Test Senaryolarini yazarken "Gherkin Language" kullanilir.
                   - Given: Ön kosullar: Endpoint, Body...
                   - When: Islemler: Get, Post, Put, Patch, Delete
                   - Then: Dönütler: Assertion, Close...
                   - And: Coklu islemlerin yapilacagi zaman kullanilir.
            c. Otomasyon kodlarini yazarken su adimlar takip edilir:
               i. Set the URL
               ii. Set the expected data
               iii. Send the request and get the response
               iv. Do assertion
     */
    public static void main(String[] args) {

        String url = "https://petstore.swagger.io/v2/pet/9898";  // Url Postman'dan aldik.
        Response response = given().when().get(url);  // given ile datayi ver dedik. when -> ara method önemsiz. get-> getir methodu.
        System.out.println(response); // Bu sekilde yazdirirsak Hash Code olarak bize görünür.
        response.prettyPrint(); // Bu sekilde özel yazdirma methodu ile ekranda sadece Body'i okunakli sekilde yazdiririz.
        /** response.prettyPrint() --> Sadece Body'i yazdirir. Ama aslinda cok kullanilmaz zaten Postman'da body görünür. */

        // Status Code nasil yazdirilir?
        System.out.println("Status Code: " + response.statusCode()); // Status Code: 200

        // Content Type nasil yazdirilir?
        System.out.println("Content Type: " + response.contentType()); // Content Type: application/json

        // Status Line nasil yazdirilir?
        System.out.println("Status Line: " + response.statusLine()); // Status Line: HTTP/1.1 200 OK

        // Header bölümündeki bir veri nasil yazdirilir?
        System.out.println("Header | Server: " + response.header("Server")); // Server: Jetty(9.2.9.v20150224)

        // Headers bölümü nasil yazdirilir?
        System.out.println("Headers: " + response.headers());

        // Time bilgisi nasil yazdirilir?
        System.out.println("Time: " + response.time()); // Time: 2316


        /**
        Burada aslinda biz Cucumber'daki gibi "Gherkin Language" kullanmis olduk. Feature'da öncelikle Gherkin dilinde
        Features-Given-When-Then-And-But-Background-*-Scenario gibi keyword'ler kullaniyorduk.
        Yani aslinda burdaki given ve when Gherkin dilindeki islevi ile aynidir.
         */
    }






}
