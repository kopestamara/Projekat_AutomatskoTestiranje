package Tests._Inventory;

import Base.BaseTest;
import Pages._Inventory_Pages.Inventory_Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
/*
    The InventoryPage_Test class contains test cases related to the functionality of the inventory page.
    It has 4 tests I need to get back to, as I didn't make them work properly as the Web Element I need cannot be inspected
 */
public class InventoryPage_Test extends BaseTest {
    private Inventory_Page inventoryPage;

    @BeforeMethod
    public void initializePages() throws IOException {
        inventoryPage=new Inventory_Page();
        testHelpers.initializationLogInStandard();
    }
    @Test (priority = 10)
    public void menuContainerOpened(){
        inventoryPage.goToSortingMenu();
        Assert.assertTrue(inventoryPage.menuOpened.isDisplayed());
    }
    //Missing assert  for next 4
    @Test (priority = 11)
    public void sortProductsNameAscending(){
        inventoryPage.orderProductsBy("name asc");
    }
    @Test (priority = 12)
    public void sortProductsNameDescending(){
        inventoryPage.orderProductsBy("name desc");
    }
    @Test (priority = 13)
    public void sortProductsPriceAscending() {
       inventoryPage.orderProductsBy("price asc");
    }
    @Test (priority = 14)
    public void sortProductsPriceDescending(){
        inventoryPage.orderProductsBy("price desc");
    }
    @Test
    public void addRemoveProducts(){
        sharedButtons.addItemToCart();
        sharedButtons.addItemToCart();
        sharedButtons.addItemToCart();
        Assert.assertEquals(sharedButtons.removeFromCart.size(), 3);
        sharedButtons.removeItemFromCart();
        sharedButtons.removeItemFromCart();
        sharedButtons.removeItemFromCart();
        Assert.assertTrue(sharedButtons.removeFromCart.isEmpty());
    }
    @Test
    public void cartBadgeNumber() {
        for (int i = 1; i < 5; i++) {
            sharedButtons.addItemToCart();
            Assert.assertEquals(sharedButtons.cartBadgeNumberOfItems(), i);
        }
        int initialItemCount = sharedButtons.cartBadgeNumberOfItems();
        for (int i = initialItemCount; i > 0; i--) {
            sharedButtons.removeItemFromCart();
        }
        testHelpers.cartBadgeAssertNotThere();
    }
    @Test
    public void clickableImages() {
        inventoryPage.goToItemByImage();
        Assert.assertTrue(sharedButtons.backToItems.isDisplayed());
    }
    @Test
    public void clickableTitles(){
        inventoryPage.goToItemByName();
        Assert.assertTrue(sharedButtons.backToItems.isDisplayed());
    }
//Every page has it, so I checked if it is working on every page
    @Test
    public void goToCart(){
        testHelpers.goToCart();
    }
    @Test
    public void goToHamburgerMenu() {
        testHelpers.goToHamburgerMenuFirst();
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.sortingMenu));
        Assert.assertTrue(inventoryPage.sortingMenu.isDisplayed());
        testHelpers.goToHamburgerMenuSecond();
    }
    @Test
    public void footerSocialMediaButtons(){
        testHelpers.footerSocialMediaButtons();
    }
}
