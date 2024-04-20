package Steps;

import Pages.AddNewEmployeePageLocators;
import Pages.DashBoardPageLocators;
import Pages.EmployeeListPageLocators;
import Pages.LoginPageLocators;

public class PageInitializer {
    public static LoginPageLocators loginpage;
    public static DashBoardPageLocators dashboard;
    public static AddNewEmployeePageLocators addemp;
    public static EmployeeListPageLocators listemp;

    public static void pageObjectsInitializer(){
        loginpage =new LoginPageLocators();
        dashboard =new DashBoardPageLocators();
        addemp =new AddNewEmployeePageLocators();
        listemp =new EmployeeListPageLocators();
    }
}
