package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

/**
 * This class models the payment page as a whole
 */
public class PaymentPage {

    private static WebDriver driver = BrowserDriver.getCurrentDriver();

    /**
     * Locators
     */
    @FindBy(id = "bookNow")
    private WebElement bookNowButon;

    // Traveler details
    @FindBy(id = "itineraryDTO.itineraryItemDTOs[0].travelers[0].firstName")
    private WebElement firstNameField;
    @FindBy(id = "itineraryDTO.itineraryItemDTOs[0].travelers[0].lastName")
    private WebElement lastNameField;

    //TODO add experience details section

    // Contact information
    @FindBy(id="contactInfoEmail")
    private WebElement emailField;
    @FindBy(id = "phoneCountryCode")
    private WebElement phoneCountryCodeDropdown;
    @FindBy(id="phoneNumber")
    private WebElement phoneNumberField;

    // Right side menu
    @FindBy(id = "rightHandRailItinerary")
    private WebElement rightSideMenu;
    @FindBy(css = "#promoCodeToggle a")
    private WebElement addPromoCodeLink;
    @FindBy(id = "promoCode")
    private WebElement promoCodeField;
    @FindBy(id = "promoCodeApplyButton")
    private WebElement promoCodeApplyButton;
    // se juega con las clases d-block y d-none
    @FindBy(id = "bookNowBtnRight")
    private WebElement bookNowRightButton;
    @FindBy(css = "#rightHandRail .paypalButtonContainer")
    private WebElement paypalRightButton;
    @FindBy(id = "chatLinkToggle")
    private WebElement chatNowLink;
    // tiene la clase hidden antes de pulsar el boton de antes
    @FindBy(className = "helpCentreShellMain")
    private WebElement helpCenter;

    // Login component
    @FindBy(css = "#loginContent a")
    private WebElement loginLink;
    // TODO para comprobar esto, hay que mirar que este webelement tenga la clase "show" tras clicar en el link
    @FindBy(id = "collapsibleLoginPanel")
    private WebElement loginPanel;

    // Payment details
    @FindBy(id = "creditCard")
    private WebElement creditCardRadioButton;
    @FindBy(id = "paypal")
    private WebElement paypalRadioButton;
    // este elemento es d-block cuando esta seleccionado credit card, y d-block cuando es paypal
    @FindBy(className = "payment-details-section")
    private WebElement paymentDetailsFieldSet;
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


    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }
}
