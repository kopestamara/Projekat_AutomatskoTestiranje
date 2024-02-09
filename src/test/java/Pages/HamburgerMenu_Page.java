package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenu_Page extends BaseTest {
    public HamburgerMenu_Page() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "inventory_sidebar_link")
    public WebElement allItems;
    public void goToAllItems(){
        allItems.click();
    }

    @FindBy (id = "about_sidebar_link")
    public WebElement about;
    public void goToAbout(){
        about.click();
    }

    @FindBy (id = "logout_sidebar_link")
    public WebElement logout;
    public void goToLogout(){
        logout.click();
    }

    @FindBy (id = "reset_sidebar_link")
    public WebElement resetAppState;
    public void goToResetAppState(){
        resetAppState.click();
    }

    @FindBy (id = "react-burger-cross-btn")
    public WebElement exitX;
    public void goToExitX(){
        exitX.click();
    }
}
