package tryone;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Books {
    @Test
    public void GetAllBooks() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("Books")
                .then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("[5].id", equalTo(6)).
                assertThat().body("[5].title",equalTo("Book 6") ).
                assertThat().body("description",not(empty()));




    }
    @Test
    public void PostBook() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"title\": \"string\",\n" +
                "  \"description\": \"string\",\n" +
                "  \"pageCount\": 0,\n" +
                "  \"excerpt\": \"string\",\n" +
                "  \"publishDate\": \"2024-03-29T22:51:07.295Z\"\n" +
                "}" ;
        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                header("Content-Type","application/json").body(body).
                when().post("Books").
                then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).

                assertThat().body("excerpt", equalTo("string"));



    }
    @Test
    public void GetBookById() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("Books/12")
                .then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("id", equalTo(12)).
                assertThat().body("title", equalTo("Book 12"));


    }
    @Test
    public void EditBookById() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"title\": \"string\",\n" +
                "  \"description\": \"string\",\n" +
                "  \"pageCount\": 0,\n" +
                "  \"excerpt\": \"string\",\n" +
                "  \"publishDate\": \"2024-03-29T22:54:25.944Z\"\n" +
                "}";
        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                header("Content-Type","application/json").body(body).
                when().put("Books/0").
                then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("id", equalTo(0)).
                assertThat().body("title", equalTo("string")).
                assertThat().body("excerpt", equalTo("string"));



    }
    @Test
    public void DeleteBookById() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().delete("Books/12")
                .then().log().all().assertThat().statusCode(200);



    }
}

