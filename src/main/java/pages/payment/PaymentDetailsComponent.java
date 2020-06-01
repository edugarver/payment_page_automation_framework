package pages.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class that models the payment details, which includes the radio buttons for selecting the payment method and the credit card details fields.
 */
public class PaymentDetailsComponent {

    private static final String PAYPAL = "PayPal";
    private static final String CREDIT_CARD = "CreditCard";

    private WebDriver driver;
    private WebDriverWait wait;

    // Payment details
    @FindBy(id = "creditCard")
    private WebElement creditCardRadioButton;
    @FindBy(id = "paypal")
    private WebElement paypalRadioButton;
    @FindBy(id = "paymentInfoFullName")
    private WebElement cardholderNameField;
    @FindBy(id = "creditCard")
    private WebElement creditCardNumberField;
    @FindBy(id = "expiryDateMonth")
    private WebElement expiryDateMonth;
    @FindBy(id = "expiryDateYear")
    private WebElement expiryDateYear;
    @FindBy(id = "securityCode")
    private WebElement securityCodeField;

    public PaymentDetailsComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30000);
    }

    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(creditCardRadioButton));
        return creditCardRadioButton.isDisplayed() && paypalRadioButton.isDisplayed();
    }

    public void selectPaymentMethod(String paymentMethod) {
        if (CREDIT_CARD.equalsIgnoreCase(paymentMethod)) {
            creditCardRadioButton.click();
        } else if (PAYPAL.equalsIgnoreCase(paymentMethod)) {
            paypalRadioButton.click();
        }
    }

    public void setCardholderNameField(String cardholderName) {
        cardholderNameField.sendKeys(cardholderName);
    }

    public void setCreditCardNumberField(String creditCardNumber) {
        driver.switchTo().frame("checkoutCDEIFrame");
        creditCardNumberField.sendKeys(creditCardNumber);
        driver.switchTo().defaultContent();
    }

    public void setExpiryDateMonth(String month) {
        driver.switchTo().frame("checkoutCDEIFrame");
        Select expiryDateMonthDropdown = new Select(expiryDateMonth);
        expiryDateMonthDropdown.selectByValue(month);
        driver.switchTo().defaultContent();
    }

    public void setExpiryDateYear(String year) {
        driver.switchTo().frame("checkoutCDEIFrame");
        Select expiryDateYearDropdown = new Select(expiryDateYear);
        expiryDateYearDropdown.selectByValue(year);
        driver.switchTo().defaultContent();
    }

    public void setSecurityCodeField(String securityCode) {
        driver.switchTo().frame("checkoutCDEIFrame");
        securityCodeField.sendKeys(securityCode);
        driver.switchTo().defaultContent();
    }
}
