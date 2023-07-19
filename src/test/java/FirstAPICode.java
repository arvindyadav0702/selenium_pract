import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
//@Listeners(ExtentReportPractice.class)
public class FirstAPICode {


    @Test
    public static void addBook() {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().header("Content-Type", "application/json").
                body(Payload.addBook()).
                when().post("/Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).
                extract().response().asString();

        System.out.println(response);

        JsonPath jsonPath = ReusableClass.rawToJson(response);
        String ID = jsonPath.getString("ID");

        Assert.assertEquals(ID, "bcd2926");
    }

    //deleting the created record
    @Test
    public void deleteRecord() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String delResponse = given().header("Content-Type", "application/json").
                body("{\n" +
                        "    \"ID\": \"bcd2926\"\n" +
                        "}").
                when().multiPart("file", new File("name.txt")).delete("/Library/DeleteBook.php").
                then().log().all().assertThat().statusCode(200).
                extract().response().asString();
//      System.out.println(delResponse);
        String delMessage = ReusableClass.rawToJson(delResponse).getString("msg");
        System.out.println(delMessage);


    }
}


//    public class DynamicJson {
//
//
//
//        @Test(dataProvider="BooksData")
//
//        public void addBook(String isbn,String aisle)
//
//
//
//        {
//
//
//
//
//            Response resp=given().
//
//                    header("Content-Type","application/json").
//
//                    body(Payload.Addbook(isbn,aisle)).
//
//                    when().
//
//                    post("/Library/Addbook.php").
//
//                    then().assertThat().statusCode(200).
//
//                    extract().response();
//
//            JsonPath js= ReusableMethods.rawToJson(resp);
//
//            String id=js.get("ID");
//
//            System.out.println(id);
//
//
//
//            //deleteBOok
//
//        }
//
//        @DataProvider(name="BooksData")
//
//        public Object[][]  getData()
//
//        {
//
////array=collection of elements
//
////multidimensional array= collection of arrays
//
//            return new Object[][] {‌{"ojfwty","9363"},{"cwetee","4253"}, {"okmfet","533"} };
//
//        }
//
//

















