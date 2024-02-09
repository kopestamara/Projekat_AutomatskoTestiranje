package Utils;

import Pages.*;
import Pages._Checkout_Pages.Cart_Page;
import Pages._Checkout_Pages.Checkout_Completed_Page;
import Pages._Checkout_Pages.Checkout_StepOne_Page;
import Pages._Checkout_Pages.Checkout_StepTwo_Page;
import Pages._Inventory_Pages.Inventory_Page;
import Pages._Inventory_Pages.SingleItem_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
//This class contains helper methods for test initialization and common actions performed across test cases.
//I also wanted for each test class to initialize only the pages that test class needed
//This cass has its own private driver as through my research I found it is not recommended for a driver to be shared to utility classes
public class TestHelpers {
    private WebDriver driver;
    private WebDriverWait wait;
    public JavascriptExecutor js;
    public ArrayList<String> listaTabova;
    private Home_Page homePage;
    private Inventory_Page inventoryPage;
    private SingleItem_Page singleItemPage;
    private Cart_Page cartPage;
    private Checkout_StepOne_Page checkoutStepOnePage;
    private Checkout_StepTwo_Page checkoutStepTwoPage;
    private Checkout_Completed_Page checkoutCompletedPage;
    private HamburgerMenu_Page hamburgerMenuPage;
    private SharedButtons_Class sharedButtonsClass;
    private ExcelDataHelper excelDataHelper;

    // Constructor to initialize the TestHelpers class with a WebDriver instance
    public TestHelpers(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to perform standard login initialization
    public void initializationLogInStandard() throws IOException {
        homePage = new Home_Page();
        excelDataHelper = new ExcelDataHelper();
        homePage.usernameLine.sendKeys(excelDataHelper.username(1));
        homePage.passwordLine.sendKeys(excelDataHelper.password(1));
        homePage.loginButton.click();
    }
    // Method to initialize the first step of the checkout process
    public void initialitazionCheckoutOne(){
        inventoryPage=new Inventory_Page();
        // Adding items to the cart and navigating to the cart
        sharedButtonsClass=new SharedButtons_Class();
        sharedButtonsClass.addItemToCart();
        sharedButtonsClass.addItemToCart();
        sharedButtonsClass.goToCart();
    }
    // Method to initialize the second step of the checkout process
    public void initialitazionCheckoutTwo() {
        cartPage=new Cart_Page();
        checkoutStepOnePage=new Checkout_StepOne_Page();
        // Clicking the checkout button and filling in checkout information
        cartPage.clickCheckout();
        checkoutStepOnePage.firstNameLine.clear();
        checkoutStepOnePage.firstNameLine.sendKeys(excelDataHelper.firstName(1));
        checkoutStepOnePage.lastNameLine.clear();
        checkoutStepOnePage.lastNameLine.sendKeys(excelDataHelper.lastName(1));
        checkoutStepOnePage.zipPostalCodeLine.clear();
        checkoutStepOnePage.zipPostalCodeLine.sendKeys(excelDataHelper.zipPostalCode(1));
        checkoutStepOnePage.clickContinue();
    }
    // Method to assert that the cart badge is not displayed
    public void cartBadgeAssertNotThere(){
        sharedButtonsClass=new SharedButtons_Class();
        boolean IsThere=false;
        try {
            sharedButtonsClass.cartBadge.isDisplayed();
            IsThere = sharedButtonsClass.cartBadge.isDisplayed();
        } catch (Exception ignored){
        }
        Assert.assertFalse(IsThere);
    }
    //These methods are used in every test to make sure the cart is accessible from every site page (except HomePage_Login_Test):

    // Method to navigate to the cart page
    public void goToCart(){
        sharedButtonsClass=new SharedButtons_Class();
        sharedButtonsClass.goToCart();
        Assert.assertTrue(sharedButtonsClass.cartButton.isDisplayed());
    }
    // Methods to check if social media buttons in footer works
    public void socialButtons(String option) {
        switch (option.toLowerCase()) {
            case "facebook":
                driver.findElement(By.className("social_facebook")).click();
                break;
            case "twitter":
                driver.findElement(By.className("social_twitter")).click();
                break;
            case "linkedin":
                driver.findElement(By.className("social_linkedin")).click();
                break;
            default:
        }
    }
    public void footerSocialMediaButtons(){
        sharedButtonsClass=new SharedButtons_Class();
        String twitter="https://twitter.com/saucelabs";
        String facebook="https://www.facebook.com/saucelabs";
        String linkedin="https://www.linkedin.com/company/sauce-labs/";
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        socialButtons("facebook");
        listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), facebook);
        listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(0));
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        socialButtons("twitter");
        listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(2));
        Assert.assertEquals(driver.getCurrentUrl(), twitter);
        listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(0));
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        socialButtons("linkedin");
        listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(3));
        Assert.assertEquals(driver.getCurrentUrl(), linkedin);
    }
    // Methods to navigate to the hamburger menu and verify elements, split in 2 because of unique verification for each page (put between these 2 methods in test classes)
    public void goToHamburgerMenuFirst () {
        sharedButtonsClass = new SharedButtons_Class();
        hamburgerMenuPage=new HamburgerMenu_Page();
        inventoryPage=new Inventory_Page();

        sharedButtonsClass.goToHamburgerMenu();
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.exitX));
        hamburgerMenuPage.goToExitX();
    }
    public void goToHamburgerMenuSecond(){
        sharedButtonsClass = new SharedButtons_Class();
        hamburgerMenuPage=new HamburgerMenu_Page();
        inventoryPage=new Inventory_Page();

        String baseURL = "https://www.saucedemo.com/";
        String aboutURL = "https://saucelabs.com/";

        sharedButtonsClass.goToHamburgerMenu();
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.allItems));
        hamburgerMenuPage.goToAllItems();
        Assert.assertTrue(inventoryPage.sortingMenu.isDisplayed());
        driver.navigate().refresh();
        sharedButtonsClass.goToHamburgerMenu();

        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.about));
        hamburgerMenuPage.goToAbout();
        Assert.assertEquals(driver.getCurrentUrl(), aboutURL);
        driver.navigate().back();
        sharedButtonsClass.goToHamburgerMenu();
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.resetAppState));
        hamburgerMenuPage.goToResetAppState();
        Assert.assertTrue(hamburgerMenuPage.exitX.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(hamburgerMenuPage.logout));
        hamburgerMenuPage.goToLogout();
        Assert.assertEquals(driver.getCurrentUrl(), baseURL);
    }
}
