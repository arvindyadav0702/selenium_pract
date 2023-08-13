package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageClasses.GoibiboPage;

import java.time.Duration;


public class GoibiboTest {
    WebDriver driver;
    GoibiboPage goibiboPageObj;


    @After
    public void tearDown() {
        driver.quit();

    }

    @Given("^User is on home page$")
    public void user_is_on_home_page() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.goibibo.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div[1]/div/div/div[2]/span/span")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


    @Given("^user selects oneway button$")
    public void user_selects_button() {
        goibiboPageObj = new GoibiboPage(driver);
        goibiboPageObj.radioButtonSelection();

    }

    @When("^user enters from \"([^\"]*)\" destination$")
    public void user_enters_from_destination(String fromCity) throws InterruptedException {
        goibiboPageObj = new GoibiboPage(driver);
        goibiboPageObj.fromSelection(fromCity);
    }

    @When("^user enters to \"([^\"]*)\" destination$")
    public void user_enters_to_destination(String toCity) throws InterruptedException {
        goibiboPageObj = new GoibiboPage(driver);
        goibiboPageObj.toSelection(toCity);
    }


    @When("^user enters \"([^\"]*)\" date$")
    public void user_enters_date(String date) throws InterruptedException {

    }

    @Then("^flight should get searched$")
    public void flight_should_get_searched() {

    }

}
