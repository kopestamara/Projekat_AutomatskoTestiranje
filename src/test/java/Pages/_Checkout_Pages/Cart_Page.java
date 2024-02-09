package Pages._Checkout_Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class Cart_Page extends BaseTest {
    public Cart_Page() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".btn.btn_secondary.btn_small.cart_button")
    public List<WebElement> removeFromCartPage;
    @FindBy (linkText = "Remove")
    public WebElement singleRemoveButton;
    public void clickSingle(){ singleRemoveButton.click();}

    @FindBy (id = "continue-shopping")
    public WebElement backToShopping;
    public void continueShopping(){
        backToShopping.click();
    }

    @FindBy (id = "checkout")
    public WebElement checkout;
    public void clickCheckout(){
        checkout.click();
    }

    @FindBy (linkText = "Your cart")
    public WebElement CartPageTitle;

    public void removeItemFromCartPage() {
        if (!removeFromCartPage.isEmpty()) {
            WebElement deleteItem = removeFromCartPage.get(0);
            deleteItem.click();
        }
    }
}
