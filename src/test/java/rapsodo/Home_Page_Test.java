package rapsodo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Card_Page;
import pages.Golf_Page;
import pages.Home_Page;

import java.time.Duration;
import java.util.Locale;

public class Home_Page_Test {

    WebDriver driver;
    Home_Page homePage;
    Card_Page cardPage;
    Golf_Page golfPage;

    @BeforeClass
    public void setup() {
        // 0- Setup: Initialize ChromeDriver and ChromeOptions
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // maximize browser window
        options.addArguments("--disable-notifications"); // disable popups

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Initialize Page Objects
        homePage = new Home_Page(driver);
        cardPage = new Card_Page(driver);
        golfPage = new Golf_Page(driver);

        // Open the website
        driver.get("https://rapsodo.com/");
    }

    @Test
    public void rapsodoShoppingFlowTest() throws InterruptedException {

        // 1- The user goes to "https://rapsodo.com" and verifies that they navigated to this address
        String expectedUrl = "https://rapsodo.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URLs are not equal");

        // The user clicks on the “Cart” icon at the top right
        // The user verifies that the shopping cart is empty
        homePage.clickCartButton();
        String expectedMessage = "Your cart is currently empty.";
        String actualMessage = cardPage.getIsCardEmpty().getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Messages are not equal");
        System.out.println("Message of my card section is: " +  actualMessage);

        // Return to the home page
        homePage.clickRapsodoLogo();

        // The user clicks on the "Golf" button and chooses "Mobile Launch Monitor (MLM)" via the “Products” button
        // Click the “Shop MLM” button
        // Verify that the page title is "Mobile Launch Monitor (MLM)"
        // Select “MOBILE LAUNCH MONITOR” from the right side of the website
        homePage.clickGolfButton();
        golfPage.scrollToMlmButton();
        golfPage.clickMlmShopButton();
        Thread.sleep(2000); // Optional: use explicit wait for more stable execution

        String expectedTitle = "Rapsodo® MLM - Mobile Launch Monitor";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles are not equal");
        System.out.println("Title is: " +  actualTitle);

        // The user clicks on the "ADD TO CART" button
        // Verify that the user is redirected to the cart page
        // Verify the price of the Mobile Launch Monitor (MLM) matches the displayed price
        String expectedPrice = "$299.99";
        String actualPrice = golfPage.getMlmPrice().getText();
        Assert.assertEquals(actualPrice, expectedPrice, "Prices are not equal");
        System.out.println("Price of the product in the cart: " + actualPrice);
        golfPage.clickAddToCartButton();


        Thread.sleep(2000);

        // The user increases the quantity (quantity = 2) of the product in the cart
        // Verify that there are two items in the cart and the total price is correct
        System.out.println("Adding one more product to the cart");
        cardPage.clickAddMoreButton();
        String expectedProductNumber = "2";
        String actualProductNumber = cardPage.getProductNumber().getAttribute("value");
        Assert.assertEquals(actualProductNumber, expectedProductNumber, "Products are not equal");

        System.out.println("Number of items in the cart: " + actualProductNumber);

        Thread.sleep(2000);

        String exptectedTotalPrice = "$599.98";
        String actualTotalPrice = cardPage.getSubTotal().getText();
        Assert.assertEquals(actualTotalPrice, exptectedTotalPrice, "Sub-total prices are not equal");
        System.out.println("Total price of the product in the cart: " + actualTotalPrice);


        Thread.sleep(2000);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}