package requests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ReadJsonUtility;

import static io.restassured.RestAssured.given;

public class Requests {

    public Requests(){

    }

    private final String baseURL = ReadJsonUtility.getStringValue("baseURL");



    public Response request1(){
        return given()
                .baseUri(baseURL)
                .when()
                .get(ReadJsonUtility.getStringValue("postsPath"));

    }

    String path2 = String.format("%s%s", ReadJsonUtility.getStringValue("postsPath"), ReadJsonUtility.getStringValue("request2Id"));
    public Response request2(){
        return given()
                .baseUri(baseURL)
                .when()
                .get(path2);
    }

    String path3 = String.format("%s%s", ReadJsonUtility.getStringValue("postsPath"), ReadJsonUtility.getStringValue("request3Id"));
    public Response request3(){
        return given()
                .baseUri(baseURL)
                .when()
                .get(path3);
    }

    public Response request4(){
        String requestBody = "{ \"title\": \"New Post\", \"body\": \"This is the body of the new post.\", \"userId\": 1 }";
        return given()
                .baseUri(baseURL)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(ReadJsonUtility.getStringValue("postsPath"));

    }

    public Response request5(){
        return given()
                .baseUri(baseURL)
                .when()
                .get(ReadJsonUtility.getStringValue("usersPath"));
    }

    String path6 = String.format("%s%s", ReadJsonUtility.getStringValue("usersPath"), ReadJsonUtility.getStringValue("userId"));
    public Response request6(){
        return given()
                .baseUri(baseURL)
                .when()
                .get(path6);
    }
}
