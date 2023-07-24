package runner;

import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


/**
 * @author oloritaiwo@gmail.com
 *
 */


@CucumberOptions(features={"src//test//java//features"}
        ,glue={"stepdefinations","LaunchApp"}
        ,plugin = {"pretty", "html:target/cucumber"}
        , tags ={"@appium"}
)
@Test
public class runTest extends AbstractTestNGCucumberTests{

}
