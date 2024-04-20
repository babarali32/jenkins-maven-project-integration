package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.commonMethods;
import utils.configReader;
public class LoginWithValidCredentialSteps extends commonMethods {
    @Given("user navigate to the HRM application")
    public void user_navigate_to_the_hrm_application() {
        openBrowser();
    }
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {

       // LoginPageLocators logins=new LoginPageLocators();

       sendText(loginpage.usernameField,configReader.getPropertyValue("username"));
       sendText(loginpage.passwordField,configReader.getPropertyValue("password"));

      //  loginpage.loginLocatorPageMethod(configReader.getPropertyValue("username"),configReader.getPropertyValue("password"));

//        loginpage.usernameField.sendKeys(configReader.getPropertyValue("username"));
//        loginpage.passwordField.sendKeys(configReader.getPropertyValue("password"));

       // WebElement username=driver.findElement(By.id("txtUsername"));

        //username.sendKeys("Admin");
      //  username.sendKeys(configReader.getPropertyValue("username"));
      //  WebElement password=driver.findElement(By.id("txtPassword"));
       // password.sendKeys("Hum@nhrm123");
       // password.sendKeys(configReader.getPropertyValue("password"));
    }
    @When("user clicks on login button")
    public void user_cliks_on_login_button() {
       // LoginPageLocators logins=new LoginPageLocators();
//        loginpage.loginField.click();

        click(loginpage.loginField);

//        WebElement button=driver.findElement(By.id("btnLogin"));
//        button.click();

    }
    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        WebElement welcomeMessage=driver.findElement(By.id("welcome"));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        System.out.println("admin has been logged in and welocme Admin is displayed ");
    }

    @When("user enters valid normal username and password")
    public void user_enters_valid_normal_username_and_password() {
        System.out.println("this user is just for example no need this ");

    }
    @Then("normal user is successfully logged in as a guest")
    public void normal_user_is_successfully_logged_in_as_a_guest() {
        closeBrowser();

    }

}


