import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","C:/Users/arvin/Documents/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//
//        driver.get("https://google.com/ncr");
//        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
//// Initialize and wait till element(link) became clickable - timeout in 10 seconds
//        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
//// Print the first result
//        driver.findElement(By.xpath("//a/h3")).click();
//        Thread.sleep(5000);
//        System.out.println(firstResult.getText());
////        driver.quit();
//
//
//        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(scr, new File(""));

                driver.switchTo().newWindow(WindowType.TAB);


    }
}