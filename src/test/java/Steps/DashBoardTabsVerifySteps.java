package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.commonMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashBoardTabsVerifySteps extends commonMethods {

    @Then("verify all the tabs are visible to the user")
    public void verify_all_the_tabs_are_visible_to_the_user(DataTable dataTable) {

        List<String> tabsFromFeatureFile=dataTable.row(0);
        List<WebElement> tabsFromWebsite=driver.findElements(By.xpath("//div[@class='menu']/ul/li"));
        List<String> storeTabsinsideListFromWebsiteTabs=new ArrayList<>();

        for (WebElement elements:tabsFromWebsite) {
            if (elements.isDisplayed()) {
                String TextFromWebsiteTabsOneByOne = elements.getText();
//                storeTabsinsideListFromWebsiteTabs.add(TextFromWebsiteTabsOneByOne);
//                Split the text into separate tabs based on newline character
                String[] tabs = TextFromWebsiteTabsOneByOne.split("\n");
                storeTabsinsideListFromWebsiteTabs.addAll(Arrays.asList(tabs));
            }
        }
        System.out.println(tabsFromFeatureFile);
        System.out.println(storeTabsinsideListFromWebsiteTabs);
        Assert.assertEquals("yes feature file tabs and tabs" +
                "from website are equals",tabsFromFeatureFile,storeTabsinsideListFromWebsiteTabs);
    }

}
