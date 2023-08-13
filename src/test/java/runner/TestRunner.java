package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        features = {"src/test/resources/Goibibo.feature"},
        glue = {"stepDefinition"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-reports.html"
                , "json:target/cucumber-reports/cucumber.json"}
//        , dryRun = true

)


public class TestRunner {


}

