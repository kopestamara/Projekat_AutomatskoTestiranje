package Pages._Checkout_Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_Completed_Page extends BaseTest {
    public Checkout_Completed_Page() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (linkText = "Checkout: Complete!")
    public WebElement title;
    @FindBy (className = "complete-header")
    public WebElement message;
}
