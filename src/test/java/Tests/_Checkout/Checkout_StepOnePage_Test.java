package Tests._Checkout;

import Base.BaseTest;
import Pages._Checkout_Pages.Cart_Page;
import Pages._Checkout_Pages.Checkout_StepOne_Page;
import Pages._Checkout_Pages.Checkout_StepTwo_Page;
import Utils.ExcelDataHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Checkout_StepOnePage_Test extends BaseTest {
    private Checkout_StepTwo_Page checkoutStepTwoPage;
    private Checkout_StepOne_Page checkoutStepOnePage;
    private Cart_Page cartPage;
    private ExcelDataHelper excelDataHelper;

    @BeforeMethod
    public void initializePages() throws IOException {
        excelDataHelper = new ExcelDataHelper();
        checkoutStepOnePage=new Checkout_StepOne_Page();
        checkoutStepTwoPage=new Checkout_StepTwo_Page();
        cartPage = new Cart_Page();
        testHelpers.initializationLogInStandard();
        testHelpers.initialitazionCheckoutOne();
        cartPage.clickCheckout();
    }
    @Test
    public void backToPreviousPage(){
        sharedButtons.clickCancel();
        boolean IsThere=false;
        try {
            sharedButtons.cancel.isDisplayed();
            IsThere=sharedButtons.cancel.isDisplayed();
        } catch (Exception e){

        }
        Assert.assertFalse(IsThere);
    }
    @Test
    public void continueToCheckout(){
        checkoutStepOnePage.clickContinue();
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutStepOnePage.titlePlace.isDisplayed());
    }
    @Test (priority = 20)
    public void informationValid(){
        String firstnameString= excelDataHelper.firstName(1);
        String lastnameString= excelDataHelper.lastName(1);
        String zipPostalCodeString= excelDataHelper.zipPostalCode(1);
        checkoutStepOnePage.userInformation(firstnameString, lastnameString, zipPostalCodeString);
        Assert.assertTrue((checkoutStepTwoPage.title.isDisplayed()));
    }
    @Test (priority = 21)
    public void informationMissingFirstName(){
        String firstnameString= "";
        String lastnameString= excelDataHelper.lastName(1);
        String zipPostalCodeString= excelDataHelper.zipPostalCode(1);
        checkoutStepOnePage.userInformation(firstnameString, lastnameString, zipPostalCodeString);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutStepOnePage.titlePlace.isDisplayed());
    }
    @Test (priority = 22)
    public void informationMissingLastName(){
        String firstnameString= excelDataHelper.firstName(1);
        String lastnameString=  "";
        String zipPostalCodeString= excelDataHelper.zipPostalCode(1);
        checkoutStepOnePage.userInformation(firstnameString, lastnameString, zipPostalCodeString);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutStepOnePage.titlePlace.isDisplayed());
    }
    @Test (priority = 23)
    public void informationMissingZipPostalCode(){
        String firstnameString= excelDataHelper.firstName(1);
        String lastnameString= excelDataHelper.lastName(1);
        String zipPostalCodeString=  "";
        checkoutStepOnePage.userInformation(firstnameString, lastnameString, zipPostalCodeString);
        Assert.assertTrue(sharedButtons.errorMessage.isDisplayed());
        Assert.assertTrue(checkoutStepOnePage.titlePlace.isDisplayed());
    }
    //Every page has it, so I checked if it is working on every page
    @Test
    public void goToCart(){
        testHelpers.goToCart();
    }
    @Test
    public void goToHamburgerMenu() throws InterruptedException {
        testHelpers.goToHamburgerMenuFirst();
        wait.until(ExpectedConditions.visibilityOf(checkoutStepOnePage.titlePlace));
        Assert.assertTrue(checkoutStepOnePage.titlePlace.isDisplayed());
        testHelpers.goToHamburgerMenuSecond();
    }
    @Test
    public void footerSocialMediaButtons(){
        testHelpers.footerSocialMediaButtons();
    }
}
