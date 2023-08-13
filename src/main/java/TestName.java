import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestName {

    public String name;
    WebDriver driver;


    @Test
    public void testingMethod() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\arvin\\Documents\\chromedriver_win32\\chromedriver.exe");

//        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("www.google.co.in");


        if (name.equalsIgnoreCase("name")) {
            driver.findElement(By.name("editbutton")).sendKeys(name);
            driver.findElement(By.name("button")).submit();
            String navPage = driver.getTitle();
            Assert.assertEquals(navPage, "This is title page");
        } else if (name.equalsIgnoreCase("name123")) {
            driver.findElement(By.name("editbutton")).sendKeys(name);
            String actual_msg = driver.findElement(By.id("emailId_err")).getText();
            String expect = "plz enter valid value";
            Assert.assertEquals(actual_msg, expect);


        }


    }
}
