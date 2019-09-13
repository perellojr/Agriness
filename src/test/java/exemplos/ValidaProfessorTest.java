package exemplos;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/exemplos/ValidaProfessor.feature", glue = { "" })
public class ValidaProfessorTest extends AbstractTestNGCucumberTests {

}
