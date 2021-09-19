package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"step_definitions"},
        plugin = {"pretty", "summary", "json:target/cucumber.json"},
        snippets = CAMELCASE,
        publish = true
)

public class RunnerTest {
}
