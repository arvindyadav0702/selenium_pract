import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

public class ListenersPractice implements ITestListener {



    public void onTestStart(ITestResult result) {
        // not implemented
        System.out.println("Test has been started");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
        softAssert.assertEquals("", "");
    }


    public void onTestSuccess(ITestResult result) {
        // not implemented
        System.out.println("Test is successful");
    }


    public void onTestFailure(ITestResult result) {
        // not implemented
        System.out.println("Test is Failed");
    }


    public void onTestSkipped(ITestResult result) {
        // not implemented
        System.out.println("Test is Skipped");

    }





}
