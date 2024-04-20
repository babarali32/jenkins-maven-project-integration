package Steps;

import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import utils.commonMethods;

public class Hooks extends commonMethods {
    @Before
    public void start() {
        openBrowser();
    }

    @After
    public void end(Scenario scenario) {
        try {
            byte[] pic;
            if (scenario.isFailed()) {
                pic = takeScreenshotss("fail/" + scenario.getName());
            } else {
                pic = takeScreenshotss("pass/" + scenario.getName());
            }
            scenario.attach(pic, "image/png", scenario.getName());
        } catch (Exception e) {
            // Handle any exceptions that might occur during screenshot capture or attachment
            e.printStackTrace();
        } finally {
            closeBrowser(); // Make sure to close the browser even if an exception occurs
        }
    }
}
