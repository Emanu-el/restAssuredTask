package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Post;
import org.testng.Assert;
import org.testng.annotations.Test;
import requests.Requests;

import java.util.List;

public class APITest {

    @Test
    public void get_post(){

        //Step 1
        Requests requests = new Requests();

        Response response = requests.getResponse1();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        //Verify the response was in JSON format
        String contentType = response.getHeader("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8", "Response is not in JSON format");

        //Extract posts and verify they are sorted ascending by id
        Post[] posts = response
                .then()
                .extract().as(Post[].class);

        for (int i = 1; i < posts.length; i++) {
            // Check if the current post's id is greater than the previous one
            Assert.assertTrue(posts[i].getID() > posts[i - 1].getID(),
                    "Posts are not sorted ascending by id");
        }


        //Step 2

        //Step 3

        //Step 4

        //Step 5

        //Step 6



    }


}
