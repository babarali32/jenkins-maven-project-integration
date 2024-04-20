package Steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.commonMethods;

public class LoginWithinvalidCredentialSteps extends commonMethods {

    @When("user enter different {string} and {string} and verify {string} message")
    public void user_enter_different_and_and_verify_message(String usernameValue, String passwordValue, String errorValue) {
        //LoginPageLocators logins=new LoginPageLocators();
        sendText(loginpage.usernameField,usernameValue);
        sendText(loginpage.passwordField,passwordValue);

//        loginpage.usernameField.sendKeys(usernameValue);
//        loginpage.passwordField.sendKeys(passwordValue);
        click(loginpage.loginField);
      //  loginpage.loginField.click();
        loginpage.errorMessageField.getText();
        String errorMessageStored=loginpage.errorMessageField.getText();

        //WebElement usernameSyntaxWebsiteLoginPage=driver.findElement(By.id("txtUsername"));
        //usernameSyntaxWebsiteLoginPage.sendKeys(usernameValue);

//        WebElement passwordSyntaxWebsiteLoginPage=driver.findElement(By.id("txtPassword"));
//        passwordSyntaxWebsiteLoginPage.sendKeys(passwordValue);
//
//        WebElement button=driver.findElement(By.id("btnLogin"));
//        button.click();

//        WebElement invalidCredentialsMessage=driver.findElement(By.id("spanMessage"));
//        String errorMessageStored=invalidCredentialsMessage.getText();

        Assert.assertEquals("feature file error message and loin" +
                "page display error message are not equeals",errorValue,errorMessageStored);


    }


}
