package Base;

import Pages.SharedButtons_Class;
import Utils.TestHelpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
/*
    The BaseTest class serves as the foundation for test classes.
    It provides setup and teardown methods that are common to multiple test cases.
    This class initializes the WebDriver, sets up common elements, and manages the test environment.
    It doesn't have @AferClass because AfterMethod is in its base the same for every Test Class
    I used PageFactory driver for packages Pages as I wanted to use the same driver, so I can learn how to make it all work
 */
public class BaseTest {
    protected static WebDriver driver;
    public SharedButtons_Class sharedButtons;
    public TestHelpers testHelpers;
    public String baseURL, inventoryURL;
    public WebDriverWait wait;
/*
     Method executed before each test method to set up the test environment.
     It initializes the WebDriver, maximizes the browser window, and sets timeouts.
     It also initializes common page elements and navigates to the base URL.
*/
    @BeforeMethod
    public void pageSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        publicPages();

        baseURL = "https://www.saucedemo.com/";
        inventoryURL = "https://www.saucedemo.com/inventory.html";
        driver.get(baseURL);
    }
    public void publicPages(){
        sharedButtons = new SharedButtons_Class();
        testHelpers = new TestHelpers(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
