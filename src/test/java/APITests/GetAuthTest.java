package APITests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAuthTest {

    private static String token;
    static String access_token;

    @Test
    public void getAccessToken() {
        String urlName = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AZEOvhUIhwn6s4Ypw8UmY2YMs0uPLfRE-4IAEPkaFgKHCVB2KQ-rWzFP-fbou_3jnVXAuQ&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
        String code = urlName.split("code=")[1].split("&scope")[0];

        RequestSpecification req = new RequestSpecBuilder().setContentType(ContentType.JSON)
                .setBaseUri("https://www.googleapis.com/oauth2/v4/token")
                .addQueryParam("code", code)
                .addQueryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .addQueryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .addQueryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .addQueryParam("grant_type", "authorization_code")
                .build();

//        RestAssured.baseURI = "https://www.googleapis.com/oauth2/v4/token";
//
//        String response = given().urlEncodingEnabled(false).
//                queryParam("code", code)
//                .queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//                .queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//                .queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
//                .queryParam("grant_type", "authorization_code")
//                .when().post()
//                .then().log().all()
//                .assertThat().statusCode(200)
//                .extract().response().asString();

        String response = given().spec(req)
                .when().post()
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        access_token = ReusableClass.rawToJson(response)
                .get("access_token");

        System.out.println(access_token);


        //pass access_token to query

        String queryoutput = given().auth().oauth2(access_token).urlEncodingEnabled(false)
                .queryParam("access_token", access_token)
                .when().post("https://rahulshettyacademy.com/getCourse.php")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println(queryoutput);
    }

    @Test(priority = 1)
    public void ValidateToken() {

        Response response = given().header("Content-Type", "application/json")
                .body("{\n" + " \"mobile\": \"2022014667\",\n" + " \"otp\": \"2432\"\n" + "}")
                .when().post("https://api.phedmanipur.com/api/v1/user/validateOtp");

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(response.body().jsonPath().getString("message"), "User Verified Successfully");

        response.prettyPrint();

        token = response.body().jsonPath().getString("data.accessToken");
        System.out.println(token);
    }

    @Test(priority = 2)

    public void getUserProfileData() {

        Response response = given().header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body("{\n" + " \"siteId\": \"1522000580\"\n" + "}")

                .when().post("https://api.phedmanipur.com/api/v1/user/getUserProfileData");

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals(response.body().jsonPath().getString("message"), "Data retrieved successfully");

        response.prettyPrint();

    }


}
