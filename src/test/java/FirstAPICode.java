import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.apache.groovy.json.internal.JsonParserUsingCharacterSource;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

//@Listeners(ExtentReportPractice.class)
public class FirstAPICode {

    private static String IDNAME;

    //Post Method Check
    @Test
    public static void addBook() {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String resp = given()
                .body("{\n" +
                        "\"name\":\"LearnAppium Automation with Java\",\n" +
                        "\"isbn\":\"bcd\",\n" +
                        "\"aisle\":\"3666\",\n" +
                        "\"author\":\"John Hello\"\n" +
                        "}\n")
                .when().urlEncodingEnabled(false).post("/Library/Addbook.php")
                .then().log().all()
                .extract().response().asString();

        System.out.println(resp);

        JsonPath js = new JsonPath(resp);
        IDNAME = js.getString("ID");

    }


    //To Get the Details
    @Test
    public void getBookDetails() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String respo = given().queryParam("ID", IDNAME)
                .when().get("/Library/GetBook.php")
                .then().log().all()
                .extract().response().asString();

        System.out.println(respo);


    }

    //To Delete the book Details

    public void deleteBookDetaiks() {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        given().when().then();
    }
//To Patch the Book Details

    public void patchBook() {

    }


}

