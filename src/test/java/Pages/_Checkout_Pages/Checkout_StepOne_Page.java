package Pages._Checkout_Pages;

import Base.BaseTest;
import Pages._Inventory_Pages.Inventory_Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_StepOne_Page extends BaseTest {
    public Checkout_StepOne_Page() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (className = "header_secondary_container")
    public WebElement titlePlace;
    @FindBy (id = "first-name")
    public WebElement firstNameLine;
    @FindBy (id = "last-name")
    public WebElement lastNameLine;
    @FindBy (id = "postal-code")
    public WebElement zipPostalCodeLine;
    @FindBy (id = "continue")
    public WebElement continueButton;
    public void clickContinue(){
        continueButton.click();
    }

    public Checkout_StepTwo_Page userInformation(String firstnameString, String lastnameString, String zipPostalCodeString){
        firstNameLine.clear();
        firstNameLine.sendKeys(firstnameString);
        lastNameLine.clear();
        lastNameLine.sendKeys(lastnameString);
        zipPostalCodeLine.clear();
        zipPostalCodeLine.sendKeys(zipPostalCodeString);
        clickContinue();
        return new Checkout_StepTwo_Page();
    }



}
