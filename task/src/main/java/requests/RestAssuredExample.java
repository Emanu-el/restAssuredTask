package requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Post;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredExample {

    // Base URL for JSONPlaceholder API
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Test
    @Parameters({"baseUrl"})
    public void playground(String baseUrl){
        //get the post24 and check for userId and title
        Post post = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Content-Type", "application/json")
                .when()
                .get("/posts/{id}", 24)
                .then()
                .statusCode(200)
                .body("userId", equalTo(3))
                .body("title", containsString("labore sunt dolores incidunt"))
                .log().all()
                .extract().as(Post.class);

        System.out.println(post.getUserId());
        System.out.println(post.getId());
        System.out.println(post.getTitle());
        System.out.println(post.getBody());


    }

    @Test
    @Parameters ({"postID"})
    public void testJsonPlaceholderApi( int postID) {
        // Task 1: Make a GET request to retrieve a list of posts
        given()
                .baseUri(BASE_URL)
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .log().all(); // Log the response details

        // Task 2: Make a POST request to create a new post
        String requestBody = "{ \"title\": \"New Post\", \"body\": \"This is the body of the new post.\", \"userId\": 1 }";
        given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .log().all();

        // Task 3: Make a GET request to retrieve the newly created post
        given()
                .baseUri(BASE_URL)
                .when()
                .get("/posts/{id}", postID) // Assuming the new post has ID 100
                .then()
                .statusCode(200)
                .log().all();
    }
}
