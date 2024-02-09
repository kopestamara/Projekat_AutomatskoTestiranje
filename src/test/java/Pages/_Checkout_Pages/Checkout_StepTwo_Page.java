package Pages._Checkout_Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_StepTwo_Page extends BaseTest {


    public Checkout_StepTwo_Page() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(className = "header_secondary_container")
    public WebElement title;
    @FindBy (className = "cart_item")
    public WebElement itemList;
    @FindBy (className = "summary_info")
    public WebElement info;
    @FindBy (id = "finish")
    public WebElement finish;
    public void clickFinish(){
        finish.click();
    }
}
