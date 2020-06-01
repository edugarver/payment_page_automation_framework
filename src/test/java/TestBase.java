import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.LandingPage;
import pages.PaymentPage;
import utils.BrowserDriver;
import utils.TestData;

/**
 * Base class for tests. It contains the setup and teardown methods, and automated TCs.
 * All TCs use an instance of PaymentPage, which is the object that contains all the methods needed in order to carry out the described flow in the TC
 */
public class TestBase {

    WebDriver driver;
    TestData testData;

    /**
     * This method will execute before each test, and it will:
     * 1. navigate to the tour url
     * 2. select the needed data in order to start the TC
     * 3. navigate to tne payment page
     */
    @BeforeEach
    public void setUp() {
        testData = new TestData("testdata.properties");
        driver = BrowserDriver.getDriver();
//        try {
//            driver = BrowserDriver.getRemoteDriver();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        driver.get(testData.getUrl());
        LandingPage landingPage = new LandingPage(driver);
        landingPage.selectNumberOfTravelers();
        landingPage.clickOnBookNowButton();
    }

    @DisplayName("TC-001: User is able to successfully book a tour using Credit Card")
    @Test
    public void tc001_successfulBookingWithCreditCard() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.setFirstNameField(testData.getValidDataFirstName());
        paymentPage.setLastNameField(testData.getValidDataLastName());
        paymentPage.setEmailField(testData.getValidDataEmail());
        paymentPage.setPhoneCountryCode(testData.getValidCountryCode());
        paymentPage.setPhoneNumberField(testData.getValidDataPhoneNumber());
        paymentPage.paymentDetailsComponent.setCardholderNameField(testData.getValidDataFirstName());
        paymentPage.paymentDetailsComponent.setCreditCardNumberField(testData.getValidCreditCardNumber());
        paymentPage.paymentDetailsComponent.setExpiryDateMonth(testData.getValidExpiryDateMonth());
        paymentPage.paymentDetailsComponent.setExpiryDateYear(testData.getValidExpiryDateYear());
        paymentPage.paymentDetailsComponent.setSecurityCodeField(testData.getValidSecurityCode());
        paymentPage.clickOnBookNowButton();
        Assertions.assertTrue(paymentPage.isCheckoutLoadingScreenDisplayed(),
                "The checkout loading screen is not displayed, but it should be");
    }

    @Disabled
    @Test
    @DisplayName("TC-002: User is able to successfully book a tour using PayPal")
    public void tc002_successfulBookingWithPayPal() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.paymentDetailsComponent.selectPaymentMethod("paypal");
        paymentPage.setFirstNameField(testData.getValidDataFirstName());
        paymentPage.setLastNameField(testData.getValidDataLastName());
        paymentPage.setEmailField(testData.getValidDataEmail());
        paymentPage.setPhoneCountryCode(testData.getValidCountryCode());
        paymentPage.setPhoneNumberField(testData.getValidDataPhoneNumber());
        paymentPage.clickOnPayWithPayPalButton();
        Assertions.assertTrue(paymentPage.isPayPalCheckoutOverlayDisplayed(),
                "The PayPal checkout overlay is not displayed, but it should be");
    }

    @Test
    @DisplayName("TC-003: Payment page shows the correct fields and tour information")
    public void tc003_paymentPageShowsCorrectInformation() {
        PaymentPage paymentPage = new PaymentPage(driver);
        Assertions.assertTrue(paymentPage.isTravelerDetailsSectionDisplayed(),
                "The 'Traveler details' section is not correctly displayed");
        Assertions.assertTrue(paymentPage.isExperienceDetailsSectionDisplayed(),
                "The 'Experience details' section is not correctly displayed");
        Assertions.assertTrue(paymentPage.isContactInformationDetailsSectionDisplayed(),
                "The 'Contact Information details' section is not correctly displayed");
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isDisplayed(),
                "The right side menu is not correctly displayed");
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.getTourInformation().contains(testData.getTourInformation()));
        Assertions.assertTrue(paymentPage.paymentDetailsComponent.isDisplayed(),
                "The 'Payment details' section is not correctly displayed");
    }

    @Test
    @DisplayName("TC-004: Traveler details fields (first name and last name) are required")
    public void tc004_firstNameLastNameAreRequired() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.setFirstNameField("");
        paymentPage.setLastNameField("");
        paymentPage.clickOnBookNowButton();
        Assertions.assertTrue(paymentPage.isFirstNameRequiredErrorMessageDisplayed(),
                "The error message 'Traveler first name is required' is not displayed");
        Assertions.assertTrue(paymentPage.isLastNameRequiredErrorMessageDisplayed(),
                "The error message 'Traveler last name is required' is not displayed");
    }

    @Test
    @DisplayName("TC-005: Traveler details fields (first name and last name) data validation")
    public void tc005_firstNameLastNameFieldsDataValidation() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.setFirstNameField(testData.getValidDataFirstNameMaxLength());
        Assertions.assertTrue(paymentPage.isFirstNameValidDisplayed(),
                "First name is not accepted, but it should be");
        paymentPage.setFirstNameField(testData.getInvalidDataFirstNameLength());
        Assertions.assertTrue(paymentPage.isFirstNameTooLongErrorMessageDisplayed(),
                "First name is accepted as valid, but it should not be");
        paymentPage.setFirstNameField(testData.getInvalidDataCharacters());
        Assertions.assertTrue(paymentPage.isFirstNameInvalidErrorMessageDisplayed(),
                "First name is accepted as valid, but it should not be");
        paymentPage.setLastNameField(testData.getValidDataLastNameMaxLength());
        Assertions.assertTrue(paymentPage.isLastNameValidDisplayed(),
                "Last name is not accepted, but it should be");
        paymentPage.setLastNameField(testData.getInvalidDataLastNameLength());
        Assertions.assertTrue(paymentPage.isLastNameTooLongErrorMessageDisplayed(),
                "Last name is accepted as valid, but it should not be");
        paymentPage.setLastNameField(testData.getInvalidDataCharacters());
        Assertions.assertTrue(paymentPage.isLastNameInvalidErrorMessageDisplayed(),
                "Last name is accepted as valid, but it should not be");
    }

    @Test
    @DisplayName("TC-012: Login link and login component basic functionality")
    public void tc012_loginComponent() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.loginComponent.clickOnLoginLink();
        Assertions.assertTrue(paymentPage.loginComponent.isDisplayed());
        paymentPage.loginComponent.setPasswordField(testData.getWrongDataPassword());
        paymentPage.loginComponent.clickOnShowPasswordButton();
        Assertions.assertTrue(paymentPage.loginComponent.isPasswordVisible(),
                "The password is hidden, but it should be visible");
        paymentPage.loginComponent.setLoginEmailField(testData.getWrongDataEmail());
        paymentPage.loginComponent.setPasswordField(testData.getWrongDataPassword());
        paymentPage.loginComponent.clickOnLoginButton();
        Assertions.assertTrue(paymentPage.loginComponent.isLoginErrorMessageDisplayed(),
                "There is no login error message, but there should be");
    }

    @Test
    @DisplayName("TC-013: Clicking on the \"Chat Now\" link opens the \"Help Center\"")
    public void tc013_clickOnChatNowButtonOpensHelpCenter() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.rightSideMenuComponent.clickOnChatNowButton();
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isHelpCenterDisplayed(),
                "Help Center is not displayed, but it should be");
    }

    @Test
    @DisplayName("TC-014: Selecting PayPal/Credit card as payment method")
    public void tc014_selectDifferentPaymentMethod() {
        PaymentPage paymentPage = new PaymentPage(driver);
        Assertions.assertTrue(paymentPage.isPaymentDetailsSectionDisplayed(),
                "The 'Payment details' section is not correctly displayed, but it should be");
        Assertions.assertTrue(paymentPage.isBookNowButtonDisplayed(),
                "'Book Now' button is not displayed, but it should be");
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isBookNowButtonDisplayed(),
                "'Book Now' button is not displayed, but it should be");
        paymentPage.paymentDetailsComponent.selectPaymentMethod("paypal");
        Assertions.assertTrue(paymentPage.isPayWithPayPalButtonDisplayed(),
                "'Pay with PayPal' button is not displayed, but it should be");
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isPayWithPaypalButtonDisplayed(),
                "'Pay with PayPal' button is not displayed, but it should be");
    }

    @Test
    @DisplayName("TC-015: \"Promo code\" section (invalid code)")
    public void tc015_promoCodeWithInvalidCode() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.rightSideMenuComponent.clickOnAddPromoCodeLink();
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isPromoCodeSectionDisplayed(),
                "Promo Code section is not displayed, but it should be");
        paymentPage.rightSideMenuComponent.setPromoCodeField(testData.getWrongDataPromoCode());
        paymentPage.rightSideMenuComponent.clickOnApplyButton();
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isInvalidPromoCodeErrorMessageDisplayed(),
                "Invalid promo code error message is not displayed, but it should be");
    }

    /**
     * After each test, we clean up by closing the webdriver instance
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
