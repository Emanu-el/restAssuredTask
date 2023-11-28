import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class RestAssuredExample {

    // Base URL for JSONPlaceholder API
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Test
    public void playground(){
        //get the post24
        RestAssured
                .given().baseUri(BASE_URL)
                .when()
                .get("/posts/{id}", 24)
                .then()
                .statusCode(200)
                .body("userId", equalTo(3))
                .log().all();

    }

    @Test
    public void testJsonPlaceholderApi() {
        // Task 1: Make a GET request to retrieve a list of posts
        RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .log().all(); // Log the response details

        // Task 2: Make a POST request to create a new post
        String requestBody = "{ \"title\": \"New Post\", \"body\": \"This is the body of the new post.\", \"userId\": 1 }";
        RestAssured
                .given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .log().all();

        // Task 3: Make a GET request to retrieve the newly created post
        RestAssured
                .given()
                .baseUri(BASE_URL)
                .when()
                .get("/posts/100") // Assuming the new post has ID 100
                .then()
                .statusCode(200)
                .log().all();
    }
}
