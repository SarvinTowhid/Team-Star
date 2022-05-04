package StepDeff;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features="C:/Users/ktowh/eclipse-workspace/CucumberMvn/src/test/resources/Features/login1.feature",

		glue= {"StepDeff"},
           dryRun=true        
           )


public class TestRunner {

}
