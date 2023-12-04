package tests;

import io.restassured.response.Response;
import models.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import requests.Requests;
import expected.ExpectedUser;
import utilities.ReadJsonUtility;

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
        Assert.assertEquals(statusCode, ReadJsonUtility.getIntValue("successCode"), "Status code is not 200");

        //Verify the response was in JSON format
        String contentType = response.getHeader("Content-Type");
        Assert.assertEquals(contentType, ReadJsonUtility.getStringValue("expectedContentType"), "Response is not in JSON format");

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
        Assert.assertEquals(statusCode, ReadJsonUtility.getIntValue("successCode"), "Status code is not the expected");

        Post post = response
                .then()
                .extract().as(Post.class);
        Assert.assertEquals(post.getUserId(), ReadJsonUtility.getIntValue("expectedUserId"), "UserId is not the expected");
        Assert.assertEquals(post.getId(), ReadJsonUtility.getIntValue("request2Id"), "Id is not the expected");
        Assert.assertNotNull(post.getTitle(), "Title is empty");
        Assert.assertNotNull(post.getBody(), "Body is empty");

        //Step 3
        response = requests.request3();
        statusCode = response.statusCode();
        Assert.assertEquals(statusCode, ReadJsonUtility.getIntValue("notFoundCode"), "Status code is not the expected");

        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody, ReadJsonUtility.getStringValue("emptyResponseBody"), "Response body is not the expected");

        //Step 4
        response = requests.request4();
        statusCode = response.statusCode();
        Assert.assertEquals(statusCode, ReadJsonUtility.getIntValue("postSuccessCode"), "Status code is not the expected");
        post = response
                .then()
                .extract().as(Post.class);
        Assert.assertEquals(post.getBody(), "This is the body of the new post.", "Body is not the expected one");
        Assert.assertEquals(post.getTitle(), "New Post", "Title is not the expected");
        Assert.assertEquals(post.getUserId(), 1, "User Id is not the expected");
        Assert.assertNotNull(post.getId(), "Id value is null");


        //Step 5
        response = requests.request5();
        statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not the expected");
        contentType = response.getHeader("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8", "Response is not in JSON format");

        User[] users = response
                .then()
                .extract().as(User[].class);

        ExpectedUser expectedUser = new ExpectedUser();
        User expectedUser1 = expectedUser.buildExpectedUser("user5");
        User responseUser = null;

        for (User user : users){
            if(user.getID() == 5){
                responseUser = user;
                break;
            }
        }

        Assert.assertEquals(expectedUser1, responseUser, "User from response doesn't match the expected user");



        //Step 6
        response = requests.request6();
        statusCode = response.statusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not the expected");
        User user = response
                .then()
                .extract().as(User.class);

        Assert.assertEquals(responseUser, user, "User from response doesn't match the expected user");

    }


}
