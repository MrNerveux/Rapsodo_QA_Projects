package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Golf_Page {
    WebDriver driver;

    public Golf_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"shopify-section-template--16514648178837__43ed1dee-d204-484e-8708-2fa55562a34d\"]/section/div/div/div[2]/div[1]/div/div[4]/div[2]/a[2]")
    private WebElement mlmShopButton;

    @FindBy(xpath = "(//*[@id=\"AddToCartForm-7328173916309\"]/button)[1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[2]/div/div/div[4]/a[1]/div[1]/span")
    private WebElement mlmPrice;

    @FindBy(xpath = "//div/div/div[2]/div[1]/h2")
    private WebElement mlm;

    public WebElement getMlmPrice(){
        return mlmPrice;
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void scrollToMlmButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", mlm);
    }

    public void clickMlmShopButton()
    {
        mlmShopButton.click();
    }


}
