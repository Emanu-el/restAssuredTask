package requests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Requests {

    public Requests(){

    }

    private String baseURL = "https://jsonplaceholder.typicode.com";

    public Response request1(){
        return given()
                .baseUri(baseURL)
                .when()
                .get("/posts");
    }

    public Response request2(){
        return given()
                .baseUri(baseURL)
                .when()
                .get("/posts/99");
    }

    public Response request3(){
        return given()
                .baseUri(baseURL)
                .when()
                .get("/posts/150");
    }

    public Response request4(){
        String requestBody = "{ \"title\": \"New Post\", \"body\": \"This is the body of the new post.\", \"userId\": 1 }";
        return given()
                .baseUri(baseURL)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts");

    }

    public Response request5(){
        return given()
                .baseUri(baseURL)
                .when()
                .get("/users");
    }

    public Response request6(){
        return given()
                .baseUri(baseURL)
                .when()
                .get("/users/5");
    }
}
