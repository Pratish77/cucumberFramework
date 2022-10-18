package test_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions
       (
		features=".//FeatureFile/",
		glue="stepDfntns",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","html:test-output"}
		
        )
public class Login_Test {
	
}
  //Customers.feature",
 //LoginFeature.feature".
//tags="@sanity,@regression"