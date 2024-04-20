package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.commonMethods;

import java.util.List;
import java.util.Map;

public class AddEmployeeByDataTableSteps extends commonMethods {

    @When("user add multiple employees and verify they are added")
    public void user_add_multiple_employees_and_verify_they_are_added(DataTable dataTable) throws InterruptedException {

     List<Map<String,String>> empoyeeData=dataTable.asMaps();
        for (Map<String,String> emp:empoyeeData
             ) {
            String  key01=emp.get("FirstName");
            String  key02=emp.get("MiddleName");
            String  key03=emp.get("LastName");
            if (key01!=null) {
                WebElement firstNameTextBox = driver.findElement(By.id("firstName"));
                firstNameTextBox.sendKeys(key01);
            }
            if (key02!=null) {
                WebElement middleNameTextBox = driver.findElement(By.id("middleName"));
                middleNameTextBox.sendKeys(key02);
            }
            if (key03!=null){
            WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
            lastNameTextBox.sendKeys(key03);
            }
            WebElement saveButton=driver.findElement(By.xpath("//input[@id='btnSave']"));
            saveButton.click();
            Thread.sleep(5000);
            WebElement PIMAddEmployeeButton=driver.findElement(By.id("menu_pim_addEmployee"));
            PIMAddEmployeeButton.click();
        }

    }
}
