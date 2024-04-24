package tryone;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CoverPhotos {
    @Test
    public void GetAllCoverPhotos() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("CoverPhotos")
                .then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("[100].id", equalTo(101)).

                assertThat().body("url",not(empty()));




    }
    @Test
    public void PostAuthors() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"idBook\": 0,\n" +
                "  \"url\": \"string\"\n" +
                "}" ;
        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                header("Content-Type","application/json").body(body).
                when().post("CoverPhotos").
                then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).

                assertThat().body("url", equalTo("string"));



    }
    @Test
    public void GetAuthorsByBookId() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("CoverPhotos/books/covers/5")
                .then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("[0].id", equalTo(5)).
                assertThat().body("[0].idBook", equalTo(5)).
                assertThat().body("url",not(empty()));


    }
    @Test
    public void GetAuthorsById() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("CoverPhotos/10")
                .then().log().all().assertThat().statusCode(200).
                assertThat().body("id", equalTo(10)).
                assertThat().body("idBook", equalTo(10)).
                assertThat().body("url",not(empty()));

    }
    @Test
    public void EditCoverPhotoById() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"idBook\": 0,\n" +
                "  \"url\": \"string\"\n" +
                "}";
        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                header("Content-Type","application/json").body(body).
                when().put("CoverPhotos/15").
                then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("id", equalTo(0)).
                assertThat().body("url", equalTo("string"));




    }
    @Test
    public void DeleteCoverPhotoById() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().delete("CoverPhotos/12")
                .then().log().all().assertThat().statusCode(200);



    }
}
