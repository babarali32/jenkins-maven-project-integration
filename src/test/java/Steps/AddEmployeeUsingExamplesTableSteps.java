package Steps;
import io.cucumber.java.en.When;
import utils.commonMethods;
public class AddEmployeeUsingExamplesTableSteps extends commonMethods {

    @When("user enter {string} and {string} and {string}")
    public void user_enter_and_and(String firstName, String middleName, String lastName) {
        sendText(addemp.firstnameField,firstName);
        sendText(addemp.middlenameField,middleName);
        sendText(addemp.lastnameField,lastName);
//
//        addemp.firstnameField.sendKeys(firstName);
//        addemp.middlenameField.sendKeys(middleName);
//        addemp.lastnameField.sendKeys(lastName);
////        WebElement firstNameTextBox=driver.findElement(By.id("firstName"));
//        //firstNameTextBox.sendKeys("lahore");
//        firstNameTextBox.sendKeys(firstName);
//        WebElement middleNameTextBox=driver.findElement(By.id("middleName"));
//        middleNameTextBox.sendKeys(middleName);
//        WebElement lastNameTextBox=driver.findElement(By.id("lastName"));
//        //lastNameTextBox.sendKeys("pakistan32");
//        lastNameTextBox.sendKeys(lastName);

    }
}
