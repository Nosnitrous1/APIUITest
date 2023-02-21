import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class RestTest {

    // Postman эхо позволяет вернуть ответ на GET запрос с значениями переменных из запроса
    @Test
    public void postmanFirstGetTest() {
        RestAssured.
                when().get("https://postman-echo.com/get?alpha=A1&betta=B2").
                then().assertThat().statusCode(200).
                and().body("args.betta", is("B2"));

    }

    // сайт https://jsonplaceholder.typicode.com/ позволяет бесплатно запускать фиктивные API запросы
    @Test
    public void postRequest() {
        String requestBody = "{\n" +
                "  \"title\": \"foo\",\n" +
                "  \"body\": \"bar\",\n" +
                "  \"userId\": \"1\" \n}";

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response =
                given().header("Content-type", "application/json")
                        .and().body(requestBody)
                        .when().post("/posts")
                        .then().extract().response();

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
        Assertions.assertEquals("bar", response.jsonPath().getString("body"));
        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
        Assertions.assertEquals("101", response.jsonPath().getString("id"));
    }
}
