package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import static com.gorest.utils.TestUtils.getRandomValue;
import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

    @Test
    public void verifyUserCreatedSuccessfully() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Mahi Thakur");
        userPojo.setEmail(getRandomValue() + "@gmail.com");
        userPojo.setGender("female");
        userPojo.setStatus("active");
        Response response = given()
                .header("Authorization", "Bearer c8fa4af5449aff5c104930482cc994318f2ae1a097c32bb596799dae3b2f6f3b")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(201);
    }

    @Test
    public void userGetSuccessfully() {
        Response response = given()
                .header("Authorization", "Bearer c8fa4af5449aff5c104930482cc994318f2ae1a097c32bb596799dae3b2f6f3b")
                .header("Connection", "keep-alive")
                .when()

                .get("/users/");
        response.prettyPrint();
        response.then().statusCode(200);

    }


    @Test
    public void userUpdateSuccessfully() {
        UserPojo userPojo = new UserPojo();

        userPojo.setName("Mahi Thakur");
        userPojo.setEmail(getRandomValue() + "@gmail.com");
        userPojo.setGender("female");
        userPojo.setStatus("active");
        Response response = given()
                .header("Authorization","Bearer c8fa4af5449aff5c104930482cc994318f2ae1a097c32bb596799dae3b2f6f3b")
                .header("Content-Type","application/json")
                .header("Connection","keep-alive")
                .when()
                .body(userPojo)
                .put("/users/2338478");
        response.prettyPrint();
        response.then().statusCode(200);

    }

    @Test
    public void userDeleteSuccessfully() {
        Response response = given()
                .header("Authorization", "Bearer c8fa4af5449aff5c104930482cc994318f2ae1a097c32bb596799dae3b2f6f3b")
                .header("Connection", "keep-alive")
                .when()
                .delete("/users/2338478");
        response.prettyPrint();
        response.then().statusCode(204);


    }
}
