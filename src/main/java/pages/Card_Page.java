package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Card_Page {
    WebDriver driver;

    public Card_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/header/div/p[1]")
    private WebElement isCardEmpty;

    @FindBy(xpath = "//*[@id=\"CartPageForm\"]/div/div[1]/div/div[2]/div[2]/div[1]/div[1]/button[2]")
    private WebElement addMoreButton;

    @FindBy(xpath = "//*[@id=\"cart_updates_52551486898547:2569949b0ce8d272add21d81a6e645c3\"]")
    private WebElement productNumber;

    @FindBy(xpath = "//*[@id=\"CartPageForm\"]/div/div[2]/div[2]/div[2]")
    private WebElement subTotal;

    public WebElement getSubTotal() {
        return subTotal;
    }

    public WebElement getProductNumber(){
        return productNumber;
    }

    public void  clickAddMoreButton() {
        addMoreButton.click();
    }

    public WebElement getIsCardEmpty(){
        return isCardEmpty;
    }
}
