package pageClasses;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoibiboPage {
    WebDriver driver;
    Integer date;

    public GoibiboPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//p[contains(text(),'One-way')]")
    WebElement onewayradio;

    @FindBy(xpath = "//p[contains(text(),'Round-trip')]")
    WebElement Roundtripradio;

    @FindBy(xpath = "//*[contains(text(), \"From\")]//parent::div")
    WebElement FrominputBox;

    @FindBy(xpath = "//*[contains(text(), \"From\")]//parent::div//following-sibling::div/div/input")
    WebElement FrominputBoxInput;

    @FindBy(xpath = "//*[contains(text(), \"To\")]//parent::div")
    WebElement ToinputBox;

    @FindBy(xpath = "//*[contains(text(), \"To\")]//parent::div//following-sibling::div/div/input")
    WebElement ToinputBoxInput;
    @FindBy(xpath = "//span[contains(text(),'Departure')]//parent::div")
    WebElement calendarIcon;
    @FindBy(xpath = "//span[contains(text(),'Departure')]//parent::div//following-sibling::div[1]")
    WebElement calendarIconExpand;
//    WebElement xpathDate = driver.findElement(By.xpath("//span[contains(text(),'Departure')]//parent::div//following-sibling::div[1]/child::div[2]/child::div/child::div/child::div[2]/child::div[1]/child::Div[3]/div/div//span[contains(text(),'Departure')]//parent::div//following-sibling::div[1]/child::div[2]/child::div/child::div/child::div[2]/child::div[1]/child::Div[3]/div/div/p[contains(text()," + date + ")]"));


    public void radioButtonSelection() {
        onewayradio.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void fromSelection(String fromCity) throws InterruptedException {
        FrominputBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        FrominputBoxInput.sendKeys(fromCity);
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"autoSuggest-list\"]//*[contains(text(), '" + fromCity + "')]"))).click().build().perform();
        System.out.println("Entered city is " + fromCity);
        Assert.assertEquals(fromCity, "Pune");

    }

    public void toSelection(String toCity) throws InterruptedException {

//        FrominputBox.sendKeys(Keys.TAB);
//        ToinputBox.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        ToinputBoxInput.sendKeys(toCity);
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"autoSuggest-list\"]//*[contains(text(), '" + toCity + "')]"))).click().build().perform();
        System.out.println("Entered city is " + toCity);
        Assert.assertEquals(toCity, "Guwahati");

    }



}
