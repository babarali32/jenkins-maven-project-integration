package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;
public class DashBoardPageLocators extends commonMethods {
    @FindBy(id = "welcome")
    public WebElement welcomeAdmin;
    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimButtonField;
    @FindBy(id = "menu_pim_addEmployee")
    public WebElement pimAddEmployeeField;
    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement pimEmployeeListField;

    public DashBoardPageLocators(){
        PageFactory.initElements(driver,this);
    }
}
