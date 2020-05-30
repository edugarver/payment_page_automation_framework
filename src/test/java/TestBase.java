import org.junit.jupiter.api.*;
import pages.LandingPage;
import pages.PaymentPage;
import utils.BrowserDriver;

public class TestBase {

    @BeforeEach
    public void setUp() {
        BrowserDriver.loadPage("https://www.viator.com/tours/Paris/Seine-River-Cruise-Bateaux-Parisiens-Sightseeing-Cruise-with-Dinner-and-Live-Music/d479-5836DINNERCRUISE");
        LandingPage landingPage = new LandingPage();
        landingPage.selectNumberOfTravelers();
        landingPage.clickOnBookNowButton();
    }

    @Test
    public void paymentPageShowsCorrectInformation() {
        PaymentPage paymentPage = new PaymentPage();
        Assertions.assertTrue(paymentPage.isTravelerDetailsSectionDisplayed(),
                "The 'Traveler details' section is not correctly displayed");
        Assertions.assertTrue(paymentPage.isExperienceDetailsSectionDisplayed(),
                "The 'Experience details' section is not correctly displayed");
        Assertions.assertTrue(paymentPage.isContactInformationDetailsSectionDisplayed(),
                "The 'Contact Information details' section is not correctly displayed");
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isDisplayed(),
                "The right side menu is not correctly displayed");
        //TODO comprobar tambien los textos del right side menu
        Assertions.assertTrue(paymentPage.paymentDetailsComponent.isDisplayed(),
                "The 'Payment details' section is not correctly displayed");
    }

    @Test
    public void firstNameLastNameAreRequired() {
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.setFirstNameField("");
        paymentPage.setLastNameField("");
        paymentPage.clickOnBookNowButton();
        Assertions.assertTrue(paymentPage.isFirstNameRequiredErrorMessageDisplayed(), "The error message 'Traveler first name is required' is not displayed");
        Assertions.assertTrue(paymentPage.isLastNameRequiredErrorMessageDisplayed(), "The error message 'Traveler last name is required' is not displayed");
        paymentPage.rightSideMenuComponent.clickOnRightMenuBookNowButton();
        Assertions.assertTrue(paymentPage.isFirstNameRequiredErrorMessageDisplayed(), "The error message 'Traveler first name is required' is not displayed");
        Assertions.assertTrue(paymentPage.isLastNameRequiredErrorMessageDisplayed(), "The error message 'Traveler last name is required' is not displayed");
    }

    @Test
    public void firstNameLastNameFieldsDataValidation() {
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.setFirstNameField("fifteencharsstr");
        Assertions.assertTrue(paymentPage.isFirstNameValidDisplayed(), "First name is not accepted, but it should be");
        paymentPage.setFirstNameField("morethanfifteencharsstr");
        Assertions.assertTrue(paymentPage.isFirstNameTooLongErrorMessageDisplayed(), "First name is accepted as valid, but it should not be");
        paymentPage.setFirstNameField("^wrongchars^123");
        Assertions.assertTrue(paymentPage.isFirstNameInvalidErrorMessageDisplayed(), "First name is accepted as valid, but it should not be");
        paymentPage.setLastNameField("thirtyfivecharactersstringAAAAAAAAA");
        Assertions.assertTrue(paymentPage.isLastNameValidDisplayed(), "Last name is not accepted, but it should be");
        paymentPage.setLastNameField("morethanthirtyfivecharactersstringAA");
        Assertions.assertTrue(paymentPage.isLastNameTooLongErrorMessageDisplayed(), "Last name is accepted as valid, but it should not be");
        paymentPage.setLastNameField("^wrongchars^123");
        Assertions.assertTrue(paymentPage.isLastNameInvalidErrorMessageDisplayed(), "Last name is accepted as valid, but it should not be");
    }

    @Test
    public void loginComponent() {
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.loginComponent.clickOnLoginLink();
        Assertions.assertTrue(paymentPage.loginComponent.isDisplayed());
        paymentPage.loginComponent.setPasswordField("password");
        paymentPage.loginComponent.clickOnShowPasswordButton();
        Assertions.assertTrue(paymentPage.loginComponent.isPasswordVisible(), "The password is hidden, but it should be visible");
        paymentPage.loginComponent.setWrongLoginCredentials();
        Assertions.assertTrue(paymentPage.loginComponent.isLoginErrorMessageDisplayed(), "There is no login error message, but there should be");
    }

    @Test
    public void clickOnChatNowButtonOpensHelpCenter() {
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.rightSideMenuComponent.clickOnChatNowButton();
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isHelpCenterDisplayed(), "Help Center is not displayed, but it should be");
    }

    @Test
    public void selectDifferentPaymentMethod() {
        PaymentPage paymentPage = new PaymentPage();
        Assertions.assertTrue(paymentPage.isPaymentDetailsSectionDisplayed(),
                "The 'Payment details' section is not correctly displayed, but it should be");
        Assertions.assertTrue(paymentPage.isBookNowButtonDisplayed(), "'Book Now' button is not displayed, but it should be");
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isBookNowButtonDisplayed(), "'Book Now' button is not displayed, but it should be");
        paymentPage.paymentDetailsComponent.selectPaymentMethod("paypal");
        Assertions.assertTrue(paymentPage.isPayWithPayPalButtonDisplayed(), "'Pay with PayPal' button is not displayed, but it should be");
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isPayWithPaypalButtonDisplayed(), "'Pay with PayPal' button is not displayed, but it should be");
    }

    @Test
    public void promoCodeWithInvalidCode() {
        PaymentPage paymentPage = new PaymentPage();
        paymentPage.rightSideMenuComponent.clickOnAddPromoCodeLink();
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isPromoCodeSectionDisplayed(), "Promo Code section is not displayed, but it should be");
        paymentPage.rightSideMenuComponent.setPromoCodeField("invalidCode");
        paymentPage.rightSideMenuComponent.clickOnApplyButton();
        Assertions.assertTrue(paymentPage.rightSideMenuComponent.isInvalidPromoCodeErrorMessageDisplayed(), "Invalid promo code error message is not displayed, but it should be");
    }

    @AfterEach
    public void tearDown() {
    }
}
