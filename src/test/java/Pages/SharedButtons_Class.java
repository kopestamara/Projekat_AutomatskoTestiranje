package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

 //This class represents a class for shared buttons and actions that can be performed on multiple pages.
public class SharedButtons_Class extends BaseTest {
    public SharedButtons_Class() {
        PageFactory.initElements(driver, this);
    }

    //Elements apricable to all pages

    @FindBy(className = "shopping_cart_link")
    public WebElement cartButton;
    public void goToCart() {
        cartButton.click();
    }

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;
    public Integer cartBadgeNumberOfItems(){
        return Integer.parseInt(driver.findElement(By.className("shopping_cart_badge")).getText());
    }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;
    public void goToHamburgerMenu() {
        hamburgerMenu.click();
    }

    //Elements aplicable to some pages

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> addToCart; //inventory & single item

    @FindBy(css = ".btn.btn_secondary.btn_small.btn_inventory")
    public List<WebElement> removeFromCart; //inventory & single item

    @FindBy(id = "cancel")
    public WebElement cancel; //step one and step two
    public void clickCancel() {
        cancel.click();
    }

    @FindBy(id = "back-to-products") //completed & single item page
    public WebElement backToItems;
    public void goBackToItems() {
        backToItems.click();
    }

    @FindBy(css = ".error-message-container.error") //home & step one
    public WebElement errorMessage;

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void addItemToCart() {
        Random random = new Random();
        int randomIndex = random.nextInt(addToCart.size());
        WebElement addRandomItem = addToCart.get(randomIndex);
        addRandomItem.click();
    }
    public void removeItemFromCart() {
        Random random = new Random();
        int randomIndex = random.nextInt(removeFromCart.size());
        WebElement deleteRandomItem = removeFromCart.get(randomIndex);
        deleteRandomItem.click();
    }
}



