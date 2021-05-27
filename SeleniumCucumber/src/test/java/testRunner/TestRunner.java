package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features =".//Features/Customer.feature",
				glue="stepDefinition",
				dryRun=false,
				monochrome=true,
				tags= "@Smoke",
				plugin= {"pretty","html:target/report/cucumber.html"}
//				plugin= {"pretty","json:target/report/cucumber.json"}
//				plugin= {"pretty","junit:target/report/cucumber.junit"}
		)
public class TestRunner {

}
