package Tests._Inventory;

import Base.BaseTest;
import Pages._Checkout_Pages.Cart_Page;
import Pages._Inventory_Pages.Inventory_Page;
import Pages._Inventory_Pages.SingleItem_Page;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
/*
    This class contains test cases related to the functionality of the Single Item Page.
 */
public class SingleItemPage_Test extends BaseTest {
    private SingleItem_Page singleItemPage;

    @BeforeMethod
    public void initializePages() throws IOException {
        Inventory_Page inventoryPage = new Inventory_Page();
        singleItemPage = new SingleItem_Page();
        testHelpers.initializationLogInStandard();
        inventoryPage.goToItemByName();
    }
    @Test
    public void addRemoveProduct() {
        Assert.assertEquals(sharedButtons.addToCart.size(), 1);
        sharedButtons.addItemToCart();
        Assert.assertEquals(sharedButtons.removeFromCart.size(), 1);
        sharedButtons.removeItemFromCart();
        Assert.assertTrue(sharedButtons.removeFromCart.isEmpty());

    }
    @Test
    public void cartBadgeNumber() {
        sharedButtons.addItemToCart();
        Assert.assertEquals(sharedButtons.cartBadgeNumberOfItems(), 1);
        sharedButtons.removeItemFromCart();
        testHelpers.cartBadgeAssertNotThere();
    }
    @Test
    public void baskToInventory() {
        sharedButtons.goBackToItems();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryURL);
    }
    //Every page has it, so I checked if it is working on every page
    @Test
    public void goToCart(){
        testHelpers.goToCart();
    }
    @Test
    public void goToHamburgerMenu() throws InterruptedException {
        testHelpers.goToHamburgerMenuFirst();
        wait.until(ExpectedConditions.visibilityOf(singleItemPage.title));
        Assert.assertTrue(singleItemPage.title.isDisplayed());
        testHelpers.goToHamburgerMenuSecond();
    }
    @Test
    public void footerSocialMediaButtons(){
        testHelpers.footerSocialMediaButtons();
    }
}