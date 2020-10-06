package cucumberOption;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "src\\test\\java\\feature",
		glue = "stepDefinitions",
		dryRun =true,
		monochrome = true,
		plugin= {"pretty","html:target/site/cucumber-report-default","json:target/site/cucumber.json"},
		snippets =SnippetType.CAMELCASE,
		tags= {"@Purchase"})
public class RunCucumber {

}
