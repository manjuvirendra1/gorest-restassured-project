package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.equalTo;


public class UserAssertionTest {

    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Verify the if the total record is 20
    @Test
    public void verifyTotalRecord() {
        response.body("size", equalTo(10));
    }
    // 2. Verify the if the name of id =  2272608 is equal to "Vimal Pilla"
    @Test
    public void verifyNameOfId2272501() {
        response.body("find{it.id == 2272501}.name", equalTo("Anwesha Pillai"));
    }
    //3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void verifySingleName() {
        response.body("[1].name", equalTo("Chetan Johar"));
    }
    //4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
    @Test
    public void verifyMultipleNames() {
        response.body("name", hasItems("Dr. Mahesh Gupta", "Pushti Abbott", "Rev. Siddarth Ganaka"));
    }
    //5. Verify the email of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void verifyEmailOfUserId() {
        response.body("find{it.id == 2272504}.email", equalTo("chetan_johar@kilback.example"));
    }
    //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void verifyStatusIsActive() {
        response.body("find{it.name =='Subhasini Trivedi'}.status", equalTo("active"));
    }
    //7. Verify the Gender = male of user name is “Niro Prajapat
    @Test
    public void verifyGender() {
        response.body("find{it.name == 'Girindra Guneta'}.gender", equalTo("female"));
    }
}
