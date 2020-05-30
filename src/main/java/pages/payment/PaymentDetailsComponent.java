package pages.payment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserDriver;

public class PaymentDetailsComponent {

    private static final String PAYPAL = "PayPal";
    private static final String CREDIT_CARD = "CreditCard";

    private static WebDriver driver = BrowserDriver.getCurrentDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30000);

    // Payment details
    @FindBy(id = "creditCard")
    private WebElement creditCardRadioButton;
    @FindBy(id = "paypal")
    private WebElement paypalRadioButton;
    @FindBy(id = "paymentInfoFullName")
    private WebElement cardholderName;
    @FindBy(id = "creditCard")
    private WebElement creditCardNumber;
    @FindBy(id = "expiryDateMonth")
    private WebElement expiryDateMonthDropdown;
    @FindBy(id = "expiryDateYear")
    private WebElement expiryDateYearDropdown;
    @FindBy(id = "securityCode")
    private WebElement securityCodeField;

    public PaymentDetailsComponent() {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(creditCardRadioButton));
        return creditCardRadioButton.isDisplayed() && paypalRadioButton.isDisplayed();
    }

    public void selectPaymentMethod(String paymentMethod) {
        if (paymentMethod.equalsIgnoreCase(CREDIT_CARD)) {
            creditCardRadioButton.click();
        } else if (paymentMethod.equalsIgnoreCase(PAYPAL)) {
            paypalRadioButton.click();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
