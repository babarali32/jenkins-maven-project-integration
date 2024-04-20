package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class AddNewEmployeePageLocators extends commonMethods {
    @FindBy(id = "firstName")
    public WebElement firstnameField;
    @FindBy(id = "middleName")
    public WebElement middlenameField;
    @FindBy(id = "lastName")
    public WebElement lastnameField;
    @FindBy(id = "chkLogin")
    public WebElement checkboxField;
    @FindBy(xpath= "//input[@id='user_name']")
    public WebElement usernameSecond;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordSecond;
    @FindBy(xpath = "//input[@id='re_password']")
    public WebElement confirmSecondPassword;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement secondSaveButton;

    @FindBy(xpath = "//input[@value='Edit']")
    public WebElement editButton;

    @FindBy(id="personal_cmbMarital")
    public WebElement martialStatusDropdown;

    @FindBy(id="personal_cmbNation")
    public WebElement nationalityDropdown;

    @FindBy (id ="employeeId")
    public WebElement captureId;

    public AddNewEmployeePageLocators(){
        PageFactory.initElements(driver,this);
    }

}
