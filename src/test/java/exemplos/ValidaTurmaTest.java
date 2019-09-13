package exemplos;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/exemplos/ValidaTurma.feature", glue = { "" })
public class ValidaTurmaTest extends AbstractTestNGCucumberTests {

}
