package Tests._Checkout;

import Base.BaseTest;
import Pages.SharedButtons_Class;
import Pages._Checkout_Pages.Cart_Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CartPage_Test extends BaseTest {
    private Cart_Page cartPage;

    @BeforeMethod
    public void initializePages() throws IOException {
        cartPage=new Cart_Page();
        testHelpers.initializationLogInStandard();
        testHelpers.initialitazionCheckoutOne();
    }
    @Test
    public void continueShoping(){
        cartPage.continueShopping();
        Assert.assertEquals(driver.getCurrentUrl(), inventoryURL);
    }
    @Test
    public void remove(){
        cartPage.removeItemFromCartPage();
        cartPage.removeItemFromCartPage();
        boolean IsThere=false;
        try {
            cartPage.singleRemoveButton.isDisplayed();
            IsThere = cartPage.singleRemoveButton.isDisplayed();
        } catch (Exception ignored){
        }
        Assert.assertFalse(IsThere);
    }
    @Test
    public void cartBage(){
        cartPage.removeItemFromCartPage();
        Assert.assertEquals(sharedButtons.cartBadgeNumberOfItems(), 1);
        cartPage.removeItemFromCartPage();
        testHelpers.cartBadgeAssertNotThere();
    }
    @Test
    public void checkout(){
        cartPage.clickCheckout();
        Assert.assertTrue(sharedButtons.cancel.isDisplayed());
    }
    //Every page has it, so I checked if it is working on every page
    @Test
    public void goToHamburgerMenu() throws InterruptedException {
        testHelpers.goToHamburgerMenuFirst();
        wait.until(ExpectedConditions.visibilityOf(cartPage.backToShopping));
        Assert.assertTrue(cartPage.backToShopping.isDisplayed());
        testHelpers.goToHamburgerMenuSecond();
    }
    @Test
    public void footerSocialMediaButtons(){
        testHelpers.footerSocialMediaButtons();
    }
}


