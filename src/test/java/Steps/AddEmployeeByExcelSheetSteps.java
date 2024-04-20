package Steps;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.commonMethods;
import utils.constants;
import utils.excelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeByExcelSheetSteps extends commonMethods {

    @When("user add multiple employees from excel file having sheet name {string} and verify added employees")
    public void user_add_multiple_employees_from_excel_file_having_sheet_name_and_verify_added_employees(String sheetNAME) throws InterruptedException {
        //AddNewEmployeePageLocators addemp=new AddNewEmployeePageLocators();


        List<Map<String,String>> allEmployee=excelReading.excelintoList(constants.EXCEL_File_PATH,sheetNAME);
        Iterator<Map<String,String>> iterator=allEmployee.iterator();
        while (iterator.hasNext()){
          Map<String,String> keys=iterator.next();

          sendText(addemp.firstnameField,keys.get("firstName"));
          sendText(addemp.middlenameField,keys.get("firstName"));
          sendText(addemp.lastnameField,keys.get("lastName"));
//
//          addemp.firstnameField.sendKeys(keys.get("firstName"));
//          addemp.middlenameField.sendKeys(keys.get("middleName"));
//          addemp.lastnameField.sendKeys(keys.get("lastName"));
////-------------------------------------------------------------------------------
//            WebElement firstNameTextBox=driver.findElement(By.id("firstName"));
//            firstNameTextBox.sendKeys(keys.get("firstName"));
//
//            WebElement middleNameTextBox=driver.findElement(By.id("middleName"));
//            middleNameTextBox.sendKeys(keys.get("middleName"));
//
//            WebElement lastNameTextBox=driver.findElement(By.id("lastName"));
//            lastNameTextBox.sendKeys(keys.get("lastName"));

            //my programe not reading data from outside file
//            WebElement picture=driver.findElement(By.id("photofile"));
//            picture.sendKeys(keys.get("photo"));
//            WebElement checkboxButton=driver.findElement(By.id("chkLogin"));

            if (!addemp.checkboxField.isSelected()) {
                addemp.checkboxField.click();
            }
            sendText(addemp.usernameSecond,keys.get("userName"));
            sendText(addemp.passwordSecond,keys.get("password"));
            sendText(addemp.confirmSecondPassword,keys.get("password"));
            click(addemp.secondSaveButton);

//            addemp.usernameSecond.sendKeys(keys.get("userName"));
//            addemp.passwordSecond.sendKeys(keys.get("password"));
//            addemp.confirmSecondPassword.sendKeys(keys.get("password"));
//            addemp.secondSaveButton.click();
//            -----------------------------------------------------------------------------
//            WebElement username2=driver.findElement(By.xpath("//input[@id='user_name']"));
//            username2.sendKeys(keys.get("userName"));

//            WebElement password2=driver.findElement(By.xpath("//input[@id='user_password']"));
//            password2.sendKeys(keys.get("password"));

//            WebElement confirmpassword=driver.findElement(By.xpath("//input[@id='re_password']"));
//            confirmpassword.sendKeys(keys.get("password"));

//            WebElement saveButton=driver.findElement(By.xpath("//input[@id='btnSave']"));
//            saveButton.click();

            WebElement PIMAddEmployeeButton=driver.findElement(By.id("menu_pim_addEmployee"));
            PIMAddEmployeeButton.click();
            Thread.sleep(5000);



        }

    }
}
