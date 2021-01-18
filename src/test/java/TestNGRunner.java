import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Feature",
        glue="com.sri.stepDefinition",
        plugin = "json:target/cucumber-reports/CucumberTestReport.json")


public class TestNGRunner {
}
