import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAuthTest {

    @Test
    public void getAccessToken() {
        String urlName = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AZEOvhUIhwn6s4Ypw8UmY2YMs0uPLfRE-4IAEPkaFgKHCVB2KQ-rWzFP-fbou_3jnVXAuQ&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
        String code = urlName.split("code=")[1].split("&scope")[0];

        RestAssured.baseURI = "https://www.googleapis.com/oauth2/v4/token";

        String response = given().urlEncodingEnabled(false).
                queryParam("code", code)
                .queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .queryParam("grant_type", "authorization_code")
                .when().post()
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        String access_token = ReusableClass.rawToJson(response)
                .get("access_token");

        System.out.println(access_token);


        //pass access_token to query

        String queryoutput = given().urlEncodingEnabled(false).
                queryParam("access_token", access_token)
                .when().post("https://rahulshettyacademy.com/getCourse.php")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println(queryoutput);
    }


}
