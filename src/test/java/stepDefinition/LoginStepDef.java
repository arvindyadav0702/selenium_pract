package stepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.*;


public class LoginStepDef {

    WebDriver driver;
    List<HashMap<String, String>> datamap; //Data driven
    ResourceBundle rb; // for reading properties file
    String br; //to store browser name
//    Dataread

//    @Before


    public void setup()    //Junit hook - executes once before starting
    {
        //Reading config.properties (for browser)
        rb = ResourceBundle.getBundle("prop");
        br = rb.getString("browser");
        System.out.println(br);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));


    }


    public void tearDown(Scenario scenario) throws IOException {
        System.out.println("Scenario status ======>" + scenario.getStatus());
        if (scenario.isFailed()) {
//            File DestFile=new File("fileWithPath");
//            File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scr, DestFile);
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }
        driver.quit();
    }

    @Given("User Launch browser")
    public void user_launch_browser() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.);

        switch (br) {
            case "chrome" -> {
//                System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", "C:/Users/arvin/Documents/chromedriver_win32/chromedriver.exe");
//                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

            }
            case "firefox" -> {
//                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }
            case "edge" -> {
//                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();

            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("opens URL {string}")
    public void opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }


    @When("User navigate to MyAccount menu")
    public void user_navigate_to_my_account() {

    }

    @When("click on Login")
    public void click_on_login() {

    }

    @When("^User enters Email as (.*) and Password as \"([^\"]*)\"$")
    public void user_enters_email_as_and_password_as(DataTable usercredentials) {
//        System.out.println("Credentials Entered");
//        List<String> rows = usercredentials.asList();
//        String userName = rows.get(0);
//        String passWord = rows.get(1);

        List<Map<String, String>> user = usercredentials.asMaps();

        for (Map<String, String> form : user) {

//            String userName = form.get(0);
//        String passWord = rows.get(1);

            String userName = form.get("Username");

            System.out.println("Username :" + userName);

            driver.findElement(By.name("Username")).sendKeys(userName);


            String passWord = form.get("Password");

            System.out.println("Password :" + passWord);

            driver.findElement(By.name("Password")).sendKeys(passWord);
            driver.switchTo().activeElement().sendKeys();


            driver.findElement(By.id("LoginBtn")).submit();
            driver.switchTo().alert().dismiss();


        }

//        driver.findElement(By.name("Username")).sendKeys(userName);
//        driver.findElement(By.name("Password")).sendKeys(passWord);
//        driver.findElement(By.id("LoginBtn")).submit();


    }

    @When("Click on Login button")
    public void click_on_login_button(DataTable dt) {

        List<Map<String, String>> datas = dt.asMaps();
        String name = datas.get(0).toString();
        String pass = datas.get(1).toString();

    }


    @Then("User navigates to MyAccount Page")
    public void user_navigates_to_my_account_page() {

        Set<String> s = driver.getWindowHandles();
        Iterator<String> st = s.iterator();

        while (st.hasNext()) {
            System.out.println("this is new window");
            st.next();
        }

    }


    //*******   Data Driven test method    **************
//    @Then("check User navigates to MyAccount Page by passing Email and Password with excel row {string}")
//    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows) {
//        datamap = DataReader.data(System.getProperty("user.dir") + "\\testData\\Opencart_LoginData.xlsx", "Sheet1");
//
//        int index = Integer.parseInt(rows) - 1;
//        String email = datamap.get(index).get("username");
//        String pwd = datamap.get(index).get("password");
//        String exp_res = datamap.get(index).get("res");
//
//        lp = new LoginPage(driver);
//        lp.setEmail(email);
//        lp.setPassword(pwd);
//
//        lp.clickLogin();
//        try {
//            boolean targetpage = macc.isMyAccountPageExists();
//
//            if (exp_res.equals("Valid")) {
//                if (targetpage == true) {
//                    MyAccountPage myaccpage = new MyAccountPage(driver);
//                    myaccpage.clickLogout();
//                    Assert.assertTrue(true);
//                } else {
//                    Assert.assertTrue(false);
//                }
//            }
//
//            if (exp_res.equals("Invalid")) {
//                if (targetpage == true) {
//                    macc.clickLogout();
//                    Assert.assertTrue(false);
//                } else {
//                    Assert.assertTrue(true);
//                }
//            }
//
//
//        } catch (Exception e) {
//
//            Assert.assertTrue(false);
//        }
//        driver.close();
//    }

    //*******   Account Registration Methods    **************


}


