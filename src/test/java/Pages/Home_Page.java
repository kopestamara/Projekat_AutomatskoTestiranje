package Pages;

import Base.BaseTest;
import Pages._Inventory_Pages.Inventory_Page;
import Utils.ExcelDataHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class Home_Page extends BaseTest {

    public Home_Page() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    public WebElement usernameLine;
    @FindBy(id = "password")
    public WebElement passwordLine;
    @FindBy(id = "login-button")
    public WebElement loginButton;

    public Inventory_Page login(String usernameString, String passwordString){
        usernameLine.clear();
        usernameLine.sendKeys(usernameString);
        passwordLine.clear();
        passwordLine.sendKeys(passwordString);
        loginButton.click();
        return new Inventory_Page();
    }
}