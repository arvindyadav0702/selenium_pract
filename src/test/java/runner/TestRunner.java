package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        features = {"src/test/resources/Login.feature"},
        glue = {"stepDefinitions"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-html-reports"
                , "json:target/cucumber-html-reports/cucumber.json"
//                , "com.epam.reportportal.cucumber.ScenarioReporter"
//                , "rerun:rerun/re
//                run.txt"
        }
//        , dryRun = true

)


public class TestRunner {


}

