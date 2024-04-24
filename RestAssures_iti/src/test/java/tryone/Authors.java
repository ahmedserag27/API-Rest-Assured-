package tryone;


import io.restassured.http.ContentType;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Authors {
    @Test
    public void GetAllAuthors() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("Authors")
                .then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("[500].id", equalTo(501)).
                assertThat().body("[5].firstName",equalTo("First Name 6") ).
                assertThat().body("firstName",not(empty()));




    }
    @Test
    public void PostAuthors() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"idBook\": 0,\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\"\n" +
                "}" ;
        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                header("Content-Type","application/json").body(body).
                when().post("Authors").
                then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).

                assertThat().body("firstName", equalTo("string")).
                assertThat().body("lastName", equalTo("string"));



    }
    @Test
    public void GetAuthorsByBookId() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("Authors/authors/books/5")
                .then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).

                assertThat().body("firstName",not(empty()));


    }
    @Test
    public void GetAuthorsById() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("Authors/10")
                .then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("idBook",not(empty())).
                assertThat().body("firstName",not(empty()));


    }
    @Test
    public void EditAuthorById() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"idBook\": 0,\n" +
                "  \"firstName\": \"string\",\n" +
                "  \"lastName\": \"string\"\n" +
                "}";
        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                header("Content-Type","application/json").body(body).
                when().put("Authors/15").
                then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("id", equalTo(0)).
                assertThat().body("firstName", equalTo("string")).
                assertThat().body("firstName", equalTo("string"));



    }
    @Test
    public void DeleteAuthorById() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().delete("Authors/12")
                .then().log().all().assertThat().statusCode(200);



    }

}
