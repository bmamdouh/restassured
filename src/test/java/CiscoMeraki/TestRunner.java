package CiscoMeraki;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TestRunner {
    private Response awardmoviesJSON;
    private String awardMoviesStr;
    @Test
    public void myTestCaseIMDB(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        awardmoviesJSON = given().header("x-rapidapi-host", "imdb8.p.rapidapi.com").header("x-rapidapi-key",
                "1305883246msh5912c105e1fc7b9p10c19ejsn416b04afc223")
                .when().queryParam("nconst", "nm0001667")
                .get("https://imdb8.p.rapidapi.com/actors/get-awards").then().assertThat().statusCode(200).extract().response();
        awardMoviesStr = awardmoviesJSON.toString();
        System.out.println(awardMoviesStr);
    }

}
