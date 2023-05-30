package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.equalTo;

public class PostAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "https://gorest.co.in/";
        RestAssured.basePath = "public/v2";

        response = given()
                .when()
                .get("/posts")
                .then().statusCode(200);
    }
    //1. Verify the if the total record is 25
    @Test
    public void verifyTotal(){
        response.body("size()",equalTo(10));
    }
    //2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”
    @Test
    public void verifyTitle(){
        response.body("findAll{it.id == 39294}.title",hasItem("Patrocinor textus sunt absum usque."));
    }
    //3. Check the single user_id in the Array list (5522)
    @Test
    public void verifySingleUserId(){
        response.body("[0].user_id",equalTo(2272684));
    }
    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void verifyMultipleIds(){
        response.body("id",hasItems(39305, 39304, 39297));
    }
    //5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcar
    //spectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.
    //Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.
    //Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco et
    //antiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequus
    //cuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique
    //adflicto. Assentator umquam pel."”
    @Test
    public void verifyBody(){
        response.body("findAll{it.user_id == 2272663}.body",hasItem("Basium adeptio aut. Suadeo quo caries. Ver corrupti quaerat. Aperio eaque dignissimos. Cedo varietas brevis. Umbra in confero. Volo triginta cursim. Optio conculco vitiosus. Atavus voveo impedit. Speculum rem sumo. Sed tripudio tibi. Conforto animus quae. Similique viduo ascit. Tantum colloco cubitum. Crur astrum confido."));
    }


}
