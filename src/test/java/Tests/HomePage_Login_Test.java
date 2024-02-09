package Tests;

import Base.BaseTest;
import Pages.Home_Page;
import Utils.ExcelDataHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
/*
    The HomePage_Login_Test class contains test cases related to user login on the home page.
    The tests use data from an Excel sheet to perform login attempts and validate the outcomes.
 */
public class HomePage_Login_Test extends BaseTest {
    private Home_Page homePage;
    private ExcelDataHelper excelDataHelper;
    public JavascriptExecutor js;

    @BeforeMethod
        public void initializePages() throws IOException {
        excelDataHelper = new ExcelDataHelper();
        homePage=new Home_Page();
        js = (JavascriptExecutor) driver;
    }
    //For available users listed on a login page
    @Test (priority = 10)
    public void standardUser(){
        String usernameString=excelDataHelper.username(1);
        String passwordString=excelDataHelper.password(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), inventoryURL);
    }
    @Test (priority = 12)
    public void lockedOutUser(){
        String usernameString=excelDataHelper.username(2);
        String passwordString=excelDataHelper.password(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
        js.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(inventoryURL);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
    }
    @Test (priority = 13)
    public void problemUser() {
        String usernameString=excelDataHelper.username(3);
        String passwordString=excelDataHelper.password(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), inventoryURL);
    }
    @Test (priority = 14)
    public void performanceGlitchUser() {
        String usernameString=excelDataHelper.username(4);
        String passwordString=excelDataHelper.password(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), inventoryURL);
    }
    @Test (priority = 15)
    public void errorUser() {
        String usernameString=excelDataHelper.username(5);
        String passwordString=excelDataHelper.password(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), inventoryURL);
    }
    @Test (priority = 16)
    public void visualUser() {
        String usernameString=excelDataHelper.username(6);
        String passwordString=excelDataHelper.password(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), inventoryURL);
    }
    //    // Various test methods for invalid login scenarios
    @Test (priority = 20)
    public void InvalidLoginReversedCredentials(){
        String usernameString=excelDataHelper.password(1);
        String passwordString=excelDataHelper.username(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
    }
    @Test (priority = 21)
    public void InvalidLoginWrongUsername(){
        String usernameString=excelDataHelper.wrongUsername(1);
        String passwordString=excelDataHelper.password(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
    }
    @Test (priority = 22)
    public void InvalidLoginWrongPassword(){
        String usernameString=excelDataHelper.username(1);
        String passwordString=excelDataHelper.wrongPassword(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
    }
    @Test (priority = 23)
    public void InvalidLoginWrongBoth(){
        String usernameString=excelDataHelper.wrongUsername(1);
        String passwordString=excelDataHelper.wrongPassword(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
    }
    @Test (priority = 24)
    public void InvalidLoginEmptyUsername(){
        String usernameString="";
        String passwordString=excelDataHelper.password(1);
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
    }
    @Test (priority = 25)
    public void InvalidLoginEmptyPassword(){
        String usernameString=excelDataHelper.username(1);
        String passwordString="";
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
    }
    @Test (priority = 26)
    public void InvalidLoginEmptyFields(){
        String usernameString="";
        String passwordString="";
        homePage.login(usernameString, passwordString);
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
    }
}
