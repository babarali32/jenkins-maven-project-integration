package Runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/APIFeatureFile/generateToken.feature",
        glue = "APISteps"     ,
        dryRun = true         ,
        monochrome = false    ,
       // tags = "@createEmployee",
       // tags = "@API",
       // tags = "@json",
      //  tags = " @getdata",

         tags = "@updateBody"    ,

        plugin = {"pretty","html:target/babarReport.html"}
        // plugin = {"beautiful","html:target/babarReport.html"}
)
public class APIRunner {

}
