package requests;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Requests {

    public Requests(){

    }

    private String baseURL = "https://jsonplaceholder.typicode.com";

    public Response getResponse1(){
        return given()
                .baseUri(baseURL)
                .when()
                .get("/posts");
    }

}
