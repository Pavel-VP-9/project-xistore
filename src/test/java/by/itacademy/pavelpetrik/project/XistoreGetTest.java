package by.itacademy.pavelpetrik.project;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class XistoreGetTest {

    @Test
    public void testXistore1() {
        String url ="https://xistore.by/";
        when().get(url).
                then().assertThat().statusCode(200);
    }
    }



