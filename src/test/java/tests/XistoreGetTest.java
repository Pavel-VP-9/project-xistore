package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;

public class XistoreGetTest {

    private String BASIC_URL="https://xistore.by/";
    private String SEARCH_QUERY="Увлажнитель";
    private String SEARCH_PARAM="search/?q=";
    @Test
    @DisplayName("Проверка возвращаемого значения statusCode(200)")
    public void testXistore1() {
        when().get(BASIC_URL).
                then().assertThat().statusCode(200);
    }
    @Test
    @DisplayName("Поиск товара")
    public void testProductSearch() {
        String searchParam =SEARCH_PARAM+SEARCH_QUERY;
        String response= when().get(BASIC_URL+searchParam).
                then().extract().response().asString();
        Assertions.assertTrue(response.contains(SEARCH_QUERY));
    }
    }



