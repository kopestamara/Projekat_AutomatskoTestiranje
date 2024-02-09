//package Tests._Checkout;
//
//import Base.BaseTest;
//import Pages._Checkout_Pages.Checkout_Completed_Page;
//import Pages._Checkout_Pages.Checkout_StepTwo_Page;
//import Pages._Inventory_Pages.Inventory_Page;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class Checkout_Completed_Test extends BaseTest {
//    private Checkout_StepTwo_Page checkoutStepTwoPage;
//    private Checkout_Completed_Page checkoutCompletedPage;
//    private Inventory_Page inventoryPage;
//
//    @BeforeMethod
//    public void initializePages() throws IOException {
//        checkoutStepTwoPage = new Checkout_StepTwo_Page();
//        checkoutCompletedPage = new Checkout_Completed_Page();
//        testHelpers.initializationlogInStandard();
//        testHelpers.initialitazionCheckoutOne();
//        testHelpers.initialitazionCheckoutTwo();
//        checkoutStepTwoPage.clickFinish();
//    }
//    @Test
//    public void backHome(){
//        sharedButtons.goBackToItems();
//    }
////Every page has it, so I checked if it is working on every page
//    @Test
//    public void goToCart(){
//        sharedButtons.goToCart();
//        //Assert
//    }
//    @Test
//    public void goToHamburgerMenu() throws InterruptedException {
//        sharedButtons.goToHamburgerMenu();
//        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.exitX));
//        Assert.assertTrue(hamburgerMenuPage.exitX.isDisplayed());
//        hamburgerMenuPage.goToExitX();
//        wait.until(ExpectedConditions.visibilityOf(checkoutCompletedPage.title));
//        Assert.assertTrue(checkoutCompletedPage.title.isDisplayed());
//
//        sharedButtons.goToHamburgerMenu();
//        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.allItems));
//        hamburgerMenuPage.goToAllItems();
//        Assert.assertTrue(inventoryPage.sortingMenu.isDisplayed());
//
//        sharedButtons.goToHamburgerMenu();
//        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.about));
//        hamburgerMenuPage.goToAbout();
//        Assert.assertEquals(driver.getCurrentUrl(), aboutURL);
//        driver.navigate().back();
//
//        sharedButtons.goToHamburgerMenu();
//        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.resetAppState));
//        hamburgerMenuPage.goToResetAppState();
//        Assert.assertTrue(hamburgerMenuPage.exitX.isDisplayed());
//
//        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.logout));
//        hamburgerMenuPage.goToLogout();
//        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
//    }
//    @Test
//    public void footerSocialMediaButtons(){
//        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//        sharedButtons.socialButtons("facebook");
//        listaTabova = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(listaTabova.get(1));
//        Assert.assertEquals(driver.getCurrentUrl(), facebook);
//        listaTabova = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(listaTabova.get(0));
//        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//        sharedButtons.socialButtons("twitter");
//        listaTabova = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(listaTabova.get(2));
//        Assert.assertEquals(driver.getCurrentUrl(), twitter);
//        listaTabova = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(listaTabova.get(0));
//        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//        sharedButtons.socialButtons("linkedin");
//        listaTabova = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(listaTabova.get(3));
//        Assert.assertEquals(driver.getCurrentUrl(), linkedin);
//    }
//}
