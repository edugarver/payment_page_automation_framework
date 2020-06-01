package pages.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class that models the right side menu
 */
public class RightSideMenuComponent {

    @FindBy(id = "rightHandRailItinerary")
    private WebElement rightSideMenu;
    @FindBy(css = "#promoCodeToggle a")
    private WebElement addPromoCodeLink;
    @FindBy(id = "promoCode")
    private WebElement promoCodeField;
    @FindBy(id = "promoCodeApplyButton")
    private WebElement promoCodeApplyButton;
    @FindBy(css = "#rightHandRail .bookNow")
    private WebElement bookNowRightButton;
    @FindBy(css = "#rightHandRail .paypalButtonContainer")
    private WebElement paypalRightButton;
    @FindBy(id = "chatLinkToggle")
    private WebElement chatNowLink;
    @FindBy(className = "helpCentreShellMain")
    private WebElement helpCenter;
    @FindBy(id = "promoCodeError")
    private WebElement promoCodeErrorMessage;

    public RightSideMenuComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        return rightSideMenu.isDisplayed();
    }

    public void clickOnRightMenuBookNowButton() {
        bookNowRightButton.click();
    }

    public void clickOnChatNowButton() {
        chatNowLink.click();
    }

    public boolean isHelpCenterDisplayed() {
        return helpCenter.isDisplayed();
    }

    public boolean isPayWithPaypalButtonDisplayed() {
        return paypalRightButton.isDisplayed();
    }

    public boolean isBookNowButtonDisplayed() {
        return bookNowRightButton.isDisplayed();
    }

    public void clickOnAddPromoCodeLink() {
        addPromoCodeLink.click();
    }

    public boolean isPromoCodeSectionDisplayed() {
        return promoCodeField.isDisplayed();
    }

    public void setPromoCodeField(String invalidCode) {
        promoCodeField.clear();
        promoCodeField.sendKeys(invalidCode);
    }

    public void clickOnApplyButton() {
        promoCodeApplyButton.click();
    }

    public boolean isInvalidPromoCodeErrorMessageDisplayed() {
        return promoCodeErrorMessage.isDisplayed();
    }

    public String getTourInformation() {
        return rightSideMenu.getText();
    }
}
