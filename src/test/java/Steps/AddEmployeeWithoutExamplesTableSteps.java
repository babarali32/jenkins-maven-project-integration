package Steps;

import io.cucumber.java.en.When;
import utils.commonMethods;

public class AddEmployeeWithoutExamplesTableSteps extends commonMethods {

    @When("user enter direct data {string} and {string} and {string}")
    public void user_enter_direct_data_and_and(String enterFirst, String enterSecond, String enterThird) {

        sendText(addemp.firstnameField,enterFirst);
        sendText(addemp.middlenameField,enterSecond);
        sendText(addemp.lastnameField,enterThird);
//
//        addemp.firstnameField.sendKeys(enterFirst);
//        addemp.middlenameField.sendKeys(enterSecond);
//        addemp.lastnameField.sendKeys(enterThird);

//        WebElement firstNameTextBox=driver.findElement(By.id("firstName"));
//        //firstNameTextBox.sendKeys("lahore");
//        firstNameTextBox.sendKeys(enterFirst);

//        WebElement middleNameTextBox=driver.findElement(By.id("middleName"));
//        middleNameTextBox.sendKeys(enterSecond);
//        WebElement lastNameTextBox=driver.findElement(By.id("lastName"));
//        //lastNameTextBox.sendKeys("pakistan32");
//        lastNameTextBox.sendKeys(enterThird);

    }
}
