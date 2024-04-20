package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;
import utils.configReader;

public class LoginPageLocators extends commonMethods {
    @FindBy   (id="txtUsername")
    public WebElement usernameField;
    @FindBy     (id="txtPassword")
    public WebElement passwordField;
    @FindBy     (id="btnLogin")
    public WebElement loginField;
    @FindBy     (id="spanMessage")
    public WebElement errorMessageField;
    public LoginPageLocators(){
        PageFactory.initElements(driver,this);
    }

    public void loginLocatorPageMethod(String user,String pass){
        sendText(usernameField, configReader.getPropertyValue("username"));
        sendText(passwordField,configReader.getPropertyValue("password"));
        click(loginField);

//        usernameField.sendKeys(user);
//        passwordField.sendKeys(pass);
          // loginField.click();
    }

}
