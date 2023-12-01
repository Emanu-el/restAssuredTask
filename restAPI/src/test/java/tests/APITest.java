package tests;

import io.restassured.response.Response;
import models.Post;
import org.testng.Assert;
import org.testng.annotations.Test;
import requests.Requests;

public class APITest {

    @Test
    public void get_post(){

        //Step 1
        Requests requests = new Requests();

        Response response;
        int statusCode;

        response = requests.request1();
        //Verify the status code is 200
        statusCode = response.getStatusCode();
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
            Assert.assertTrue(posts[i].getId() > posts[i - 1].getId(),
                    "Posts are not sorted ascending by id");
        }

        //Step 2
        response = requests.request2();
        statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        Post post = response
                .then()
                .extract().as(Post.class);
        Assert.assertEquals(post.getUserId(), 10, "UserId is not the expected");
        Assert.assertEquals(post.getId(), 99, "Id is not the expected");
        Assert.assertNotNull(post.getTitle(), "Title is empty");
        Assert.assertNotNull(post.getBody(), "Body is empty");

        //Step 3
        response = requests.request3();
        statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 404, "Status code is not the expected");

        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody, "{}", "Response body is not the expected");

        //Step 4
        response = requests.request4();
        statusCode = response.statusCode();
        post = response
                .then()
                .extract().as(Post.class);
        Assert.assertEquals(statusCode, 201, "Status code is not the expected");
        Assert.assertEquals(post.getBody(), "This is the body of the new post.", "Body is not the expected one");
        Assert.assertEquals(post.getTitle(), "New Post", "Title is not the expected");
        Assert.assertEquals(post.getUserId(), 1, "User Id is not the expected");
        Assert.assertNotNull(post.getId(), "Id value is null");


        //Step 5


        //Step 6



    }


}
