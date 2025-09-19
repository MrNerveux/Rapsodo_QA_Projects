package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
    WebDriver driver;

    public Home_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"MainMenu\"]/div/div[3]/div[2]/div[1]/a[2]")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"MainMenu\"]/div/div[1]/div/a")
    private WebElement rapsodoLogo;

    @FindBy(xpath = "//*[@id=\"MainMenu\"]/div/div[2]/nav/ul/li[1]/a")
    private WebElement golfButton;

    public void clickGolfButton() {
        golfButton.click();
    }

    public void clickRapsodoLogo() {
        rapsodoLogo.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

}
