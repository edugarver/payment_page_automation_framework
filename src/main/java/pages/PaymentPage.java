package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.payment.LoginComponent;
import pages.payment.PaymentDetailsComponent;
import pages.payment.RightSideMenuComponent;
import utils.BrowserDriver;

/**
 * This class models the payment page as a whole
 */
public class PaymentPage {

    private static final String FIRST_NAME_REQUIRED_ERROR_MESSAGE = "Traveler first name is required";
    private static final String LAST_NAME_REQUIRED_ERROR_MESSAGE = "Traveler last name is required";
    private static final String FIRST_NAME_INVALID_ERROR_MESSAGE = "Traveler first name is invalid";
    private static final String LAST_NAME_INVALID_ERROR_MESSAGE = "Traveler last name is invalid";
    private static final String FIRST_NAME_TOO_LONG_ERROR_MESSAGE = "Traveler first name is too long";
    private static final String LAST_NAME_TOO_LONG_ERROR_MESSAGE = "Traveler last name is too long";

    private static WebDriver driver = BrowserDriver.getCurrentDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30000);

    /**
     * Components of Payment page
     */
    public RightSideMenuComponent rightSideMenuComponent;
    public LoginComponent loginComponent;
    public PaymentDetailsComponent paymentDetailsComponent;

    /**
     * Locators
     */
    @FindBy(id = "bookNow")
    private WebElement bookNowButton;
    @FindBy(id = "paypalButtonContainer")
    private WebElement payWithPayPalButton;
    @FindBy(className = "payment-details-section")
    private WebElement paymentDetailsSection;
    @FindBy(id = "itineraryDTO.itineraryItemDTOs[0].travelers[0].firstName")
    private WebElement firstNameField;
    @FindBy(id = "itineraryDTO.itineraryItemDTOs[0].travelers[0].lastName")
    private WebElement lastNameField;
    @FindBy(id = "specialRequirementsOptionalField-0")
    private WebElement specialRequirementsField;
    // Contact information
    @FindBy(id = "contactInfoEmail")
    private WebElement emailField;
    @FindBy(id = "phoneCountryCode")
    private WebElement phoneCountryCodeDropdown;
    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;
    @FindBy(css = ".traveler-first-name .parsley-required")
    private WebElement firstNameRequiredErrorMessage;
    @FindBy(css = ".traveler-last-name .parsley-required")
    private WebElement lastNameRequiredErrorMessage;
    @FindBy(css = ".traveler-first-name .parsley-pattern")
    private WebElement firstNameInvalidErrorMessage;
    @FindBy(css = ".traveler-last-name .parsley-pattern")
    private WebElement lastNameInvalidErrorMessage;
    @FindBy(css = ".traveler-first-name .parsley-length")
    private WebElement firstNameTooLongErrorMessage;
    @FindBy(css = ".traveler-last-name .parsley-length")
    private WebElement lastNameTooLongErrorMessage;

    public PaymentPage() {
        PageFactory.initElements(driver, this);
        rightSideMenuComponent = new RightSideMenuComponent();
        loginComponent = new LoginComponent();
        paymentDetailsComponent = new PaymentDetailsComponent();
    }

    public boolean isTravelerDetailsSectionDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(bookNowButton));
        return firstNameField.isDisplayed() && lastNameField.isDisplayed();
    }

    public boolean isExperienceDetailsSectionDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(bookNowButton));
        return specialRequirementsField.isDisplayed();
    }

    public boolean isContactInformationDetailsSectionDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(bookNowButton));
        return emailField.isDisplayed() && phoneCountryCodeDropdown.isDisplayed() && phoneNumberField.isDisplayed();
    }

    public void setFirstNameField(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void clickOnBookNowButton() {
        bookNowButton.click();
    }

    public boolean isFirstNameRequiredErrorMessageDisplayed() {
        return firstNameRequiredErrorMessage.isDisplayed() &&
                firstNameRequiredErrorMessage.getText().contains(FIRST_NAME_REQUIRED_ERROR_MESSAGE);
    }

    public boolean isLastNameRequiredErrorMessageDisplayed() {
        return lastNameRequiredErrorMessage.isDisplayed() &&
                lastNameRequiredErrorMessage.getText().contains(LAST_NAME_REQUIRED_ERROR_MESSAGE);
    }

    public boolean isFirstNameValidDisplayed() {
        return firstNameField.getAttribute("class").contains("is-valid");
    }

    public boolean isFirstNameInvalidErrorMessageDisplayed() {
        return firstNameInvalidErrorMessage.isDisplayed() &&
                firstNameInvalidErrorMessage.getText().contains(FIRST_NAME_INVALID_ERROR_MESSAGE);
    }

    public boolean isFirstNameTooLongErrorMessageDisplayed() {
        return firstNameTooLongErrorMessage.isDisplayed() &&
                firstNameTooLongErrorMessage.getText().contains(FIRST_NAME_TOO_LONG_ERROR_MESSAGE);
    }

    public boolean isLastNameValidDisplayed() {
        return lastNameField.getAttribute("class").contains("is-valid");
    }

    public boolean isLastNameInvalidErrorMessageDisplayed() {
        return lastNameInvalidErrorMessage.isDisplayed() &&
                lastNameInvalidErrorMessage.getText().contains(LAST_NAME_INVALID_ERROR_MESSAGE);
    }

    public boolean isLastNameTooLongErrorMessageDisplayed() {
        return lastNameTooLongErrorMessage.isDisplayed() &&
                lastNameTooLongErrorMessage.getText().contains(LAST_NAME_TOO_LONG_ERROR_MESSAGE);
    }

    public boolean isPayWithPayPalButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(payWithPayPalButton));
        return payWithPayPalButton.isDisplayed();
    }

    public boolean isBookNowButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(bookNowButton));
        return bookNowButton.isDisplayed();
    }

    public boolean isPaymentDetailsSectionDisplayed() {
        return paymentDetailsSection.getAttribute("class").contains("d-block");
    }
}
