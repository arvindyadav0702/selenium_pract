package APITests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

//@Listeners(ExtentReportPractice.class)
public class FirstAPICode {

    private static String IDNAME;

    //Post Method Check
    @Test
    public static void addBook() {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        RequestSpecification rs = RestAssured.given();
        Response resp = rs
                .body("{\n" +
                        "\"name\":\"LearnAppium Automation with Java\",\n" +
                        "\"isbn\":\"bcd\",\n" +
                        "\"aisle\":\"5332\",\n" +
                        "\"author\":\"John Hello\"\n" +
                        "}\n")
                .when().urlEncodingEnabled(false).post("/Library/Addbook.php");

        long timeTaken = resp.timeIn(TimeUnit.MILLISECONDS);
        String responseAsString = resp.then().log().all()
                .extract().response().asString();

        System.out.println(responseAsString);
        System.out.println("Time taken is================= " + timeTaken);
        JsonPath js = new JsonPath(responseAsString);
        IDNAME = js.getString("ID");

    }




    //To Get the Details
    @Test
    public void getBookDetails() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        Response respo = given().queryParam("ID", IDNAME)
                .when().get("/Library/GetBook.php");
//
//        System.out.println(respo);

        long timeTaken = respo.getTimeIn(TimeUnit.MILLISECONDS);
        String responseAsString = respo.then().log().all()
                .extract().response().asString();

        System.out.println(responseAsString);
        System.out.println("Time taken is================= " + timeTaken);


    }

    //To Delete the book Details
@Test
    public void deleteBookDetaiks() {

        RestAssured.baseURI = "https://rahulshettyacademy.com/Library/Addbook.php";
        Response re = given().multiPart(new File("C:\\Users\\arvin\\Downloads\\coforge.pdf"))
                .when().urlEncodingEnabled(false).post("/Library/Addbook.php");

        re.then().extract().response().asString();
//        JsonPath js = new JsonPath()
    System.out.println(re.then().extract().response().asString());

    }
//To Patch the Book Details

    public void patchBook() {

    }


}
