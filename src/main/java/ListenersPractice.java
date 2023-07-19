import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersPractice implements ITestListener {



    public void onTestStart(ITestResult result) {
        // not implemented
        System.out.println("Test has been started");
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
