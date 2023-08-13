package APITests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class BooksAPIStep {
    private static final String USER_ID = "9b5f49ab-eea9-45f4-9d66-bcf56a531b85";
    private static final String USERNAME = "TOOLSQA-Test";
    private static final String PASSWORD = "Test@@123";
    private static final String BASE_URL = "https://bookstore.toolsqa.com";

    private static Response response;
    private static String token;
    private static String bookID;

    @Given("user enters credentials to generate token code")
    public void user_enters_credentials_to_generate_token_code() {

        RestAssured.baseURI = BASE_URL;
        RequestSpecification requestSpecification = RestAssured.given();

        response = requestSpecification.contentType("application/json")
                .body("{ \"userName\":\"" + USERNAME + "\",\"password\":\"" + PASSWORD + "\"}")
                .when().post("/Account/v1/GenerateToken");

        String resp = response.then().log().all()
                .statusCode(200)
                .extract().response().asString();

        JsonPath js = new JsonPath(resp);
        token = js.get("token");
        System.out.println(token);
    }

    @Given("a list of books are available")
    public void a_list_of_books_are_available() {
        RestAssured.baseURI = BASE_URL;

        RequestSpecification rs = RestAssured.given();

        Response res = rs.when().get("/BookStore/v1/Books");
        String books = res.then().extract().response().asString();

        JsonPath jsonPath = new JsonPath(books);
        List<Map<String, String>> booksdet = jsonPath.get("books");
        Assert.assertFalse(booksdet.isEmpty());

        bookID = booksdet.get(0).get("isbn");
        System.out.println(bookID);

    }

    @When("i add a book")
    public void i_add_a_book() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookID + "\" } ]}")
                .post("/BookStore/v1/Books");

    }

    @Then("a book is added")
    public void a_book_is_added() {
        Assert.assertEquals(201, response.getStatusCode());

    }

    @When("i remove a book")
    public void i_remove_a_book() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + bookID + "\", \"userId\": \"" + USER_ID + "\"}")
                .delete("/BookStore/v1/Book");
    }


    @Then("the book is removed")
    public void the_book_is_removed() {
        Assert.assertEquals(204, response.getStatusCode());

        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + USER_ID);
        Assert.assertEquals(200, response.getStatusCode());

        String jsonString = response.asString();
        List<Map<String, String>> booksOfUser = JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, booksOfUser.size());

    }
}




