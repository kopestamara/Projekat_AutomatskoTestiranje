package Pages._Inventory_Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleItem_Page extends BaseTest {
    public SingleItem_Page() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".inventory_details_name.large_size")
    public WebElement title;
    @FindBy (className = "inventory_details_img")
    public WebElement image;
    @FindBy (className = "inventory_details_price")
    public WebElement price;
    @FindBy (css = ".inventory_details_desc.large_size")
    public WebElement description;

}
