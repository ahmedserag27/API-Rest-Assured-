package tryone;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Users {
    @Test
    public void GetAllUsers() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("Users")
                .then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("[3].id", equalTo(4)).
                assertThat().body("[5].userName",equalTo("User 6") ).
                assertThat().body("password",not(empty()));




    }
    @Test
    public void PostUser() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"userName\": \"string\",\n" +
                "  \"password\": \"string\"\n" +
                "}" ;
        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                header("Content-Type","application/json").body(body).
                when().post("Users").
                then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).

                assertThat().body("userName", equalTo("string")).
                assertThat().body("password", equalTo("string"));




    }
    @Test
    public void GetUserById() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("Users/12")
                .then().log().all().assertThat().statusCode(404).
                assertThat().contentType(ContentType.JSON);



    }
    @Test
    public void EditUserById() {
        String body = "{\n" +
                "  \"id\": 0,\n" +
                "  \"userName\": \"string\",\n" +
                "  \"password\": \"string\"\n" +
                "}";
        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                header("Content-Type","application/json").body(body).
                when().put("Users/15").
                then().log().all().assertThat().statusCode(200).
                assertThat().contentType(ContentType.JSON).
                assertThat().body("id", equalTo(0)).
                assertThat().body("userName", equalTo("string")).
                assertThat().body("password", equalTo("string"));



    }
    @Test
    public void DeleteUserById() {

        given().log().all().baseUri("https://fakerestapi.azurewebsites.net/api/v1").
                when().get("users/12")
                .then().log().all().assertThat().statusCode(404);



    }
}
