package home_search;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "use_cases",
                 plugin = "html:target/cucumber/wikipedia.html",
                 monochrome = true , 
                 snippets = io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE, 
                 glue = {"home_search"}
                 ,strict = true)

public class acceptance_test {

}
