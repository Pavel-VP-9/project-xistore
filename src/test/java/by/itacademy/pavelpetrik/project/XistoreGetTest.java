package by.itacademy.pavelpetrik.project;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class XistoreGetTest {

    @Test
    public void testXistore1() {
        String url ="https://xistore.by/";


       //String url = "https://xistore.by/catalog/irrigatory/irrigator_enchen_mint_3/";
       // String url = "https://xistore.by/search/?q=Enchen+Mint+3";
        when().get(url).
                then().assertThat().statusCode(200);
    }
    }



