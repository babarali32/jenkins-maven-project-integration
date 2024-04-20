package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // feature option we use to provide the path of all feature files
        features = "src/test/resources/features/addEmployeeFromExcelFile.feature",
        // glue option we use for step declaration , we just provide package name
        glue = "Steps" ,
        // dry run option is used to generate code for un-implemented steps
        dryRun = false,
        // it removes all the irrelevant information from the console

        monochrome = true ,
        tags = "@excelFile",
        // tags = "@search And not @addEmployee"
        //tags = "@search or @addEmployee"
        //tags = "@search And @addEmployee"
        //plugin = {"ugly","html:target/babarReport.html"}
        //plugin = {"beautiful","html:target/babarReport.html"}
        plugin = {"pretty","html:target/babarReport.html","json:target/cucumber.json"}
        //this plugin print the steps in console
)
public class excelFile {
}
