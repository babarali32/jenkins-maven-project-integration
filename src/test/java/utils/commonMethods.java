package utils;

import Steps.PageInitializer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class commonMethods extends PageInitializer {
    public static WebDriver driver;
    @Test
    public static void openBrowser() {
        configReader.readProperties(constants.PATH);
        String browser = configReader.getPropertyValue("browser");
        if (browser.equals("chrome")) {
           // System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            // these below three lines are for so that chrome browser can not open or close for jenkins
//            ChromeOptions chromeOptions=new ChromeOptions();
//            chromeOptions.setHeadless(true);
//            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("Firefox")) {//System.setProperty("webdriver.gecko.driver", "src/Driver/geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(20,TimeUnit.Seconds);
       // driver.manage().timeouts().implicitlyWait(constants.IMPLICIT_WAIT,TimeUnit.Seconds);
        driver.get(configReader.getPropertyValue("url"));
        pageObjectsInitializer();

    }
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }

    }
    public static void sendText(WebElement element,String sendToText){
        element.clear();
        element.sendKeys(sendToText);
    }
    public static WebDriverWait getwait(){
        WebDriverWait wait=new WebDriverWait(driver,constants.EXPLICIT_WAIT);

        return wait;
    }
    public static void waitForClickability(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }
    public static JavascriptExecutor getJavSript(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js;
    }
    public static void jsClick(WebElement element){
        getJavSript().executeScript("arguments[0].click()",element);
    }
    public static void selectDropDown(WebElement element,String text){
        Select select=new Select(element);
        select.selectByVisibleText(text);
        //select.selectByValue("Married");
        //select.selectByIndex(3);  -- inplace of String text make, int text
    }
    public static byte[] takeScreenshotss(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        try {
            String timestamp = getTimeStamp("yyyy-MM-dd-HH-mm-ss");
            File screenshotFile = new File(constants.SCREEN_SHOT_FILE_PATH + filename + " " + timestamp + ".png");
            FileUtils.writeByteArrayToFile(screenshotFile, picBytes);
            return picBytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getTimeStamp(String datePattern) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        return dateFormat.format(date);
    }
}