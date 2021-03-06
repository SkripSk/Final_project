import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"raffeisen.mortgage"},
        plugin = {"json:target/cucumber-report.json",
                  "pretty",
                  "html:target/cucumber-reports",
                  "raffeisen.mortgage.reporter.AllureReporter"},
        tags = {"@Test"})
public class CucumberRunner {
}
