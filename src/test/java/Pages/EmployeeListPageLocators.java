package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class EmployeeListPageLocators extends commonMethods {
    @FindBy(id="empsearch_id")
    public WebElement idTextBoxField;

    @FindBy(id="searchBtn")
    public WebElement searchButtonField;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement nameSearchField;

    public EmployeeListPageLocators(){
        PageFactory.initElements(driver,this);
    }
}
