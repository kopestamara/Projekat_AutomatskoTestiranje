package Pages._Inventory_Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class Inventory_Page extends BaseTest {
    public Inventory_Page() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (className = "inventory_item_name")
    public List<WebElement> itemByName;
    @FindBy(className = "inventory_item_img")
    public List<WebElement> itemByImage;
    @FindBy(className = "inventory_item_price")
    public List<WebElement> itemByPrice;
    @FindBy(className = "header_secondary_container")
    public WebElement menuOpened;
    @FindBy (className = "product_sort_container")
    public WebElement sortingMenu;
    public void goToSortingMenu(){
        sortingMenu.click();
    }

    public void orderProductsBy(String option){ //MISSING CLICK ON MENU AND THEN SELECT. BUT IT WON'T SELECT. WON'T LET ME INSPECT
            switch (option.toLowerCase()) {
                case "name asc":
                    sortingMenu.click();
                    driver.findElement(By.cssSelector("option[value='az']")).click();
                    break;
                case "name desc":
                    sortingMenu.click();
                    driver.findElement(By.cssSelector("option[value='za']")).click();
                    break;
                case "price asc":
                    sortingMenu.click();
                    driver.findElement(By.cssSelector("option[value='lohi']")).click();
                    break;
                case "price desc":
                    sortingMenu.click();
                    driver.findElement(By.cssSelector("option[value='hilo']")).click();
                    break;
                default:
            }
        }
    public void goToItemByName(){
        Random random=new Random();
        int randomIndex = random.nextInt(itemByName.size());
        WebElement randomItem = itemByName.get(randomIndex);
        randomItem.click();
        }
    public void goToItemByImage(){
        Random random=new Random();
        int randomIndex = random.nextInt(itemByImage.size());
        WebElement randomItem = itemByImage.get(randomIndex);
        randomItem.click();
    }
}
