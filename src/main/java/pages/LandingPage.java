package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserDriver;

public class LandingPage {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30000);

    @FindBy(css = "div.pax-input-box")
    private WebElement numberOfTravelersBox;
    @FindBy(id = "applyPaxButton")
    private WebElement applyButton;

    public LandingPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectNumberOfTravelers() {
         numberOfTravelersBox.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        applyButton.click();
    }

    public void clickOnBookNowButton() {
        By bookNowButtonsLocator = By.cssSelector("div.add-to-cart-wrapper");
        wait.until(ExpectedConditions.visibilityOfElementLocated(bookNowButtonsLocator));
        driver.findElement(bookNowButtonsLocator).click();
    }
}
